package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Search {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        search(start, "js").forEach(System.out::println);
    }

    public static List<Path> search(Path root, String ext) {
        List<Path> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(root.toFile());
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (child.getName().endsWith(ext)) {
                result.add(child.toPath());
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return result;
    }
}
