package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {

    private Object[] container = new Object[10];
    private int count = 0;
    private int modCount = 0;

    public T get(int index) {
        return (T) container[Objects.checkIndex(index, count)];
    }

    public void add(T model) {
        chechSizeAndGrow();
        container[count++] = model;
        modCount++;
    }

    private void chechSizeAndGrow() {
        if (count == container.length) {
            container = Arrays.copyOf(container, count * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int cursor = 0;
            private int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[cursor] != null;
            }

            @Override
            public T next() {
                if (!hasNext() || container[cursor] == null) {
                    throw new NoSuchElementException();
                }
                return (T) container[cursor++];
            }
        };
    }
}