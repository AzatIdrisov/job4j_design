package ru.job4j.collection;

import java.util.List;

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        return null;

    }

    public static class User {
        private int id;
        private String name;
    }

    public static class Info {

        private int added;
        private int changed;

        private int deleted;

    }

}