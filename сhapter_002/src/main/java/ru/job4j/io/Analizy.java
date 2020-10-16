package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> result = new ArrayList<String>();
        String startTime = "", lastTime;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            String line = read.readLine();
            while (line != null) {
                System.out.println(line);
                    if (line.equals("")) {
                        line = read.readLine();
                        continue;
                    }
                    if (Integer.parseInt(line.substring(0, 3)) >= 400 && startTime.equals("")) {
                        startTime = line.substring(4);
                    }
                    if (Integer.parseInt(line.substring(0, 3)) < 400 && !startTime.equals("")) {
                        lastTime = line.substring(4);
                        result.add(startTime + ";" + lastTime + ";");
                        startTime = "";
                    }
                line = read.readLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            result.stream().forEach(el -> out.println(el));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean checkError(String logLine) {
        boolean result = true;
        return result;
    }

    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}