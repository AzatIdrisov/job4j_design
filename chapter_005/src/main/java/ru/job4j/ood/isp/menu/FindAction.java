package ru.job4j.ood.isp.menu;

import java.util.LinkedList;
import java.util.Queue;

public class FindAction implements Find {
    private Item parent;

    public FindAction(Item parent) {
        this.parent = parent;
    }

    @Override
    public Item find(String key) {
        Queue<String> queue = new LinkedList<>();
        char[] temp = key.toCharArray();
        String test;
        for (var e : temp) {
            test = "" + e;
            if (!test.matches("[0-9.]*")) {
               throw new IllegalArgumentException("Пункт меню введен неверно.");
            }
            if (test.matches("[0-9]*")) {
                queue.add(test);
            }
        }
        Item current = parent;
        while (!queue.isEmpty()) {
            int currentNum = Integer.parseInt(queue.poll());
            for (var e : current.getMenuItems()) {
                if (e.getId() == currentNum) {
                    current = e;
                }
            }
        }
        return current;
    }
}
