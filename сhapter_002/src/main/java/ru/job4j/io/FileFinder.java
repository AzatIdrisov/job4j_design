package ru.job4j.io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.util.function.Predicate;

public class FileFinder {
    private final String[] args;

    public FileFinder(String[] args) {
        this.args = args;
    }

    public String[] getArgs() {
        return args;
    }

    public Predicate<File> findByName() {
        return (file) -> {
            if (file.isDirectory()) {
                return false;
            }
            return file.getName().equals(args[3]);
        };
    }

    public Predicate<File> findByMask() {
        return (file) -> {
            if (file.isDirectory() || !file.getName().contains(".")) {
                return false;
            }
            String fileName = file.getName();
            String fileMask = fileName.substring(fileName.indexOf('.'));
            return fileMask.equals(args[3]);
        };
    }

    public Predicate<File> getPredicate() {
        if (args[2].equals("-f")) {
            return findByName();
        } else {
                return findByMask();
        }
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

    private List<String> findFiles(File directory, Predicate<File> rule) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);
        List<String> foundFiles = new ArrayList<>();
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (rule.test(child)) {
                foundFiles.add(child.getAbsolutePath());
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
            for (String line : log) {
                out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        FileFinder fileFinder = new FileFinder(args);
        if (fileFinder.valid()) {
            File directory = new File(fileFinder.getArgs()[1]);
            List<String> foundFiles = fileFinder.findFiles(directory, fileFinder.getPredicate());
            save(foundFiles, args[5]);
        }
    }
}
