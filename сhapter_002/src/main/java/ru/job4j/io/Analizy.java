package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        List<String> result = new ArrayList<String>();
        Iterator<String> iterator = lines.iterator();
        String temp, startTime = "", lastTime;
        while (iterator.hasNext()) {
            temp = iterator.next();
            if (temp.equals("")) {
                continue;
            }
            if (Integer.parseInt(temp.substring(0, 3)) >= 400 && startTime.equals("")) {
                startTime = temp.substring(4);
            }
            if (Integer.parseInt(temp.substring(0, 3)) < 400 && !startTime.equals("")) {
                lastTime = temp.substring(4);
                result.add(startTime + ";" + lastTime + ";");
                startTime = "";
            }
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            result.stream().forEach(el -> out.println(el));
        } catch (Exception e) {
            e.printStackTrace();
        }
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