package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        List<String> lines = new ArrayList<String>();
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(lines::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        lines.stream()
                .filter(line -> !line.contains("#") && line.contains("="))
                .forEach(line -> values.put(line.substring(0, line.indexOf('=')),
                        line.substring(line.indexOf('=') + 1)));
        values.keySet().stream().forEach(key -> System.out.println(key + "    " + values.get(key)));
    }

    public String value(String key) {
        //throw new UnsupportedOperationException("Don't impl this method yet!");
        return values.get(key);
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config config = new Config("app.properties");
        System.out.println(config);
        config.load();
    }
}