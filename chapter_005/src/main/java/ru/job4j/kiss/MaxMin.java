package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiPredicate;

public class MaxMin {

    public <T> T max(List<T> value, Comparator<T> comparator) {
        return reduce(value, (x, y) -> comparator.compare(x, y) > 0);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        return reduce(value, (x, y) -> comparator.compare(x, y) < 0);
    }

    public <T> T reduce(List<T> value, BiPredicate<T, T> predicate) {
        T result = null;
        for (T el : value) {
            if (predicate.test(el, result)) {
                result = el;
            }
        }
        return result;
    }
}
