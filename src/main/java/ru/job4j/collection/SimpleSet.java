package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    public void add(T element) {
        boolean check = true;
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                check = false;
                break;
            }
        }
        if (check) {
            set.add(element);
        }
    }

    public T get(int index) {
        return set.get(index);
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
