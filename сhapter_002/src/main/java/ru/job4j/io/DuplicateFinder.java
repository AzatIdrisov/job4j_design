package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.util.*;

public class DuplicateFinder {

    public static List<String> findDuplicate(Path root) {
        List<File> files = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(root.toFile());
        List<String> duplicates = new ArrayList<>();
        while (!queue.isEmpty()) {
            File child = queue.poll();
            for (File file : files) {
                if (file.getName().equals(child.getName()) && file.length() == child.length()) {
                    duplicates.add(child.toPath() + " && " + file.toPath());
                    System.out.println("Duplicates: " + child.toPath() + " && " + file.toPath());
                    break;
                }
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
            files.add(child);
        }
        return duplicates;
    }
}
