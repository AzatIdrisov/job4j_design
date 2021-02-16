package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        T max = value.get(0);
        for (T el : value) {
            max = comparator.compare(max, el) < 0 ? el : max;
        }
        return max;
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        T min = value.get(0);
        for (T el : value) {
            min = comparator.compare(min, el) > 0 ? el : min;
        }
        return min;
    }
}
