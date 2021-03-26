package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayIt<T> implements Iterator<T> {
    private final T[] data;
    private int point = 0;

    public ArrayIt(T[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return point < data.length;
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}