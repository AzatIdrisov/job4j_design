package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new FileReader("even.txt"))) {
            int[] numbers = in.lines().mapToInt(Integer::parseInt).toArray();
            for (int num:numbers) {
                if (num % 2 == 0) {
                    System.out.println(num + " is even");
                } else {
                    System.out.println(num + " is not even");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
