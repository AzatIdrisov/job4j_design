package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {
        String result = "";
        for (int i = 1; i < 10; i++) {
            result += "1 * " + i + " = " + i + "\r\n";
        }
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            out.write(result.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}