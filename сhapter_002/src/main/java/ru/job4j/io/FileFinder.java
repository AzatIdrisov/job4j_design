package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class FileFinder {
    private final String[] args;

    public FileFinder(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public Boolean findByMask(File file, String mask) {
        if (file.isDirectory() || !file.getName().contains(".")) {
            return false;
        }
        String fileName = file.getName();
        String fileMask = fileName.substring(fileName.indexOf('.'));
        return fileMask.equals(mask);
    }

    public Boolean findByName(File file, String name) {
        if (file.isDirectory()) {
            return false;
        }
        return file.getName().equals(name);
    }

    public boolean valid() {
        if (args.length == 0) {
            System.out.println("Parameters are not given");
            return false;
        }
        if (!args[0].equals("-d") || !(new File(args[1]).isDirectory())) {
            System.out.println("Root folder is not given");
            return false;
        }
        if (!(args[2].equals("-m") || args[2].equals("-f"))) {
            System.out.println("File's name or file's extension is not given");
            return false;
        }
        if (!args[4].equals("-o") || args[5].equals("")) {
            System.out.println("Target file is not given");
            return false;
        }
        return true;
    }

    private List<String> findFiles(File directory, String rule, String name) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);
        List<String> foundFiles = new ArrayList<>();
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (rule.equals("-m") && findByMask(child, name)) {
                foundFiles.add(child.getName());
            } else if (rule.equals("-f") && findByName(child, name)) {
                foundFiles.add(child.toPath().toString());
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return foundFiles;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            StringBuilder result = new StringBuilder();
            for (String line : log) {
                result.append(line).append(System.lineSeparator());
            }
            out.write(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileFinder fileFinder = new FileFinder(args);
        if (fileFinder.valid()) {
            File directory = new File(fileFinder.getArgs()[1]);
            List<String> foundFiles = fileFinder.findFiles(directory, fileFinder.getArgs()[2],
                    fileFinder.getArgs()[3]);
            save(foundFiles, args[5]);
        }
    }
}
