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
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder and file extension are not given");
        }
        if (args.length == 1) {
            throw new IllegalArgumentException("File extension is not given");
        }
        Path start = Paths.get(args[0]);
        search(start, file -> file.getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<File> predicate) throws IOException {
        PrintFiles searcher = new PrintFiles(predicate);
        Files.walkFileTree(root, searcher);
        return searcher.getFiles();
    }
}
