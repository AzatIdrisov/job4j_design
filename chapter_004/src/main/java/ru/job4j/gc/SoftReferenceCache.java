package ru.job4j.gc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public class SoftReferenceCache {
    private Map<String, SoftReference<String>> cache = new HashMap<>();

    public String get(String key) {
        String result;
        SoftReference<String> reference = cache.get(key);
        if (reference == null) {
            result = load(key);
        } else {
            result = reference.get();
        }
        return result;
    }

    public String load(String fileName) {
        String result = null;
        try (BufferedReader read = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder(System.lineSeparator());
            read.lines().forEach(stringBuilder::append);
            result = stringBuilder.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        cache.put(fileName, new SoftReference<>(result));
        return result;
    }
}
