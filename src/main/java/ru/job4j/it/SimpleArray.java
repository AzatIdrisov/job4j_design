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
        int checkedIndex = Objects.checkIndex(index, count);
        System.arraycopy(array,
                checkedIndex + 1,
                array,
                checkedIndex,
                array.length - checkedIndex - 1);
        count--;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIt(array);
    }
}
