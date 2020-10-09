package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            List<String> lines = new ArrayList<>();
            String temp;
            while ((temp = in.readLine()) != null) {
                lines.add(temp);
            }
            for (String line : lines) {
                temp = line.substring(line.indexOf('"') + 1);
                temp = temp.substring(temp.indexOf('"') + 2);
                if (Integer.parseInt(temp.substring(0, 3)) == 404) {
                    result.add(line);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        log.stream().forEach(System.out::println);
    }
}