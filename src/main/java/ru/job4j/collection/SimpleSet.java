package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {

    private SimpleArray<T> set = new SimpleArray<>();

    public void add(T element) {
        if (!contains(element)) {
            set.add(element);
        }
    }

    public boolean contains(T value) {
        Iterator<T> iterator = set.iterator();
        while (iterator.hasNext()) {
            if (Objects.equals(iterator.next(), value)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
