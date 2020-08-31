package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private int point = 0;
    private int[] data;

    public EvenIt(final int[] numbers) {
        this.data = numbers;
    }

    @Override
    public boolean hasNext() {
        while (point < data.length && data[point] % 2 != 0) {
            point++;
        }
        return point < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[point++];
    }
}

