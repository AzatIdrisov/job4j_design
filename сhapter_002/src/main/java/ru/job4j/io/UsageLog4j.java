package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int height = 180;
        long  dist = 5555;
        short num = 230;
        byte age = 33;
        char type = 'A';
        float weight = 77.8f;
        double salary = 45000.5;
        boolean sleep = false;
        LOG.debug("User info name : {}, age : {}, height : {}, dist : {}, num : {}, type : {}, "
                + "weight : {},salary : {}, sleep : {}", name, age, height, dist,
                num, type, weight, salary, sleep);
    }
}