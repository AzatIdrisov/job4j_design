package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleSetTest {

    @Test
    public void whenAddGet() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        String rsl = set.iterator().next();
        assertThat(rsl, is("first"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenMultiplyAdd() {
        SimpleSet<String> set = new SimpleSet<>();
        set.add("first");
        set.add("second");
        set.add("second");
        Iterator<String> iterator = set.iterator();
        iterator.next();
        iterator.next();
        iterator.next();
    }
}