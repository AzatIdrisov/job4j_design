package ru.job4j.io;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class ArgZip {

    private final String[] args;
    private final Map<String, String> parametrs = new HashMap<>();

    public ArgZip(String[] args) {
        this.args = args;
    }

    public boolean valid() {
        if (args.length == 0) {
            System.out.println("Parametr are not given");
            return false;
        }
        if (!args[0].equals("-d") || !(new File(args[1]).isDirectory())) {
            System.out.println("Root folder is not given");
            return false;
        } else {
            parametrs.put(args[0], args[1]);
        }
        if (!args[2].equals("-e") || !args[3].startsWith(".")) {
            System.out.println("File extension is not given");
            return false;
        } else {
            parametrs.put(args[2], args[3]);
        }
        if (!args[4].equals("-o") || args[5].equals("")) {
            System.out.println("Target file is not given");
            return false;
        } else {
            parametrs.put(args[4], args[5]);
        }
        return true;
    }

    public String directory() {
        return parametrs.get("-d");
    }

    public String exclude() {
        return parametrs.get("-e");
    }

    public String output() {
        return parametrs.get("-o");
    }
}