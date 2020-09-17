package ru.job4j.collection;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddGet() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        String rsl = set.get(0);
        assertThat(rsl, is("first"));
    }

    @Test (expected = IndexOutOfBoundsException.class)
    public void whenMultiplyAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("second");
        set.add("second");
        set.get(3);
    }
}