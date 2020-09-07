package ru.job4j.it;

import java.util.Iterator;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private final T[] array;
    private int count = 0;

    public SimpleArray(int size) {
        array = (T[]) new Object[size];
    }

    public void add(T model) {
        if (count == array.length) {
            throw new IllegalStateException("There is no free cells in array");
        }
        array[count++] = model;
    }

    public void set(int index, T model) {
        array[Objects.checkIndex(index, count)] = model;
    }

    public T get(int index) {
        return array[Objects.checkIndex(index, count)];
    }

    public void remove(int index) {
        if (index < count && index >= 0) {
            System.arraycopy(array, index + 1, array, index, array.length - index - 1);
            count--;
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIt(array);
    }
}
