package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;

public class Search {

    public static void main(String[] args) throws IOException {
        Path start = Paths.get(".");
        search(start, file -> file.getName().endsWith(".js")).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<File> predicate) throws IOException {
        PrintFiles searcher = new PrintFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getFiles();
    }
}
