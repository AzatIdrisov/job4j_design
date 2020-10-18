package ru.job4j.io;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        search(start, file -> file.getName().endsWith(".js")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<File> predicate) {
        List<Path> result = new ArrayList<>();
        Queue<File> queue = new LinkedList<>();
        queue.offer(root.toFile());
        while (!queue.isEmpty()) {
            File child = queue.poll();
            if (predicate.test(child)) {
                result.add(child.toPath());
            }
            if (child.isDirectory()) {
                queue.addAll(Arrays.asList(child.listFiles()));
            }
        }
        return result;
    }
}
