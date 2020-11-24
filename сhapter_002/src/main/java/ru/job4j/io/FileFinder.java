package ru.job4j.io;

import java.io.*;
import java.util.*;
import java.util.function.BiFunction;

public class FileFinder {
    private static final String FINDBYNAME = "-f";
    private static final String FINDBYMASK = "-m";
    private final String[] args;
    private final Map<String, BiFunction<File, String, Boolean>> dispatch = new HashMap<>();

    public FileFinder(String[] args) {
        this.args = args;
        this.dispatch.put(FINDBYNAME, findByName());
        this.dispatch.put(FINDBYMASK, findByMask());
    }

    public BiFunction<File, String, Boolean> findByName() {
        return (file, name) -> {
            if (file.isDirectory()) {
                return false;
            }
            return file.getName().equals(name);
        };
    }

    public BiFunction<File, String, Boolean> findByMask() {
        return (file, mask) -> {
            if (file.isDirectory() || !file.getName().contains(".")) {
                return false;
            }
            String fileName = file.getName();
            String fileMask = fileName.substring(fileName.indexOf('.'));
            return fileMask.equals(mask);
        };
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

    private List<String> findFiles(File directory, BiFunction<File, String, Boolean> rule) {
        Queue<File> queue = new LinkedList<>();
        queue.offer(directory);
        List<String> foundFiles = new ArrayList<>();
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (rule.apply(child, args[3])) {
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
            File directory = new File(args[1]);
            List<String> foundFiles = fileFinder.findFiles(directory,
                    fileFinder.dispatch.get(args[2]));
            save(foundFiles, args[5]);
        }
    }
}
