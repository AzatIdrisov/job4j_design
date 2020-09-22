package ru.job4j.collection;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleHashMapTest {

    @Test
    public void whenInsertGet() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(8);
        map.insert("Test", "Test map");
        String rsl = map.get("Test");
        assertThat(rsl, is("Test map"));
    }

    @Test
    public void whenMultyplyInsertThenResize() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        map.insert("Test2", "Test map");
        map.insert("Test3", "Test map");
        int expectedSize = map.size();
        assertThat(expectedSize, is(4));
    }

    @Test
    public void whenInsertAndDelete() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        assertThat(map.delete("Test1"), is(true));
    }

    @Test
    public void whenInsertAndMultiplyHasNext() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        Iterator<String> iterator = map.iterator();
        iterator.hasNext();
        iterator.hasNext();
        assertThat(iterator.hasNext(), is(true));
    }

    @Test
    public void whenInsertAndGetFromIterator() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        Iterator<String> iterator = map.iterator();
        assertThat(iterator.next(), is("Test map"));
    }

    @Test (expected = NoSuchElementException.class)
    public void whenMultiplyNext() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        Iterator<String> iterator = map.iterator();
        iterator.next();
        iterator.next();
    }

    @Test
    public void whenInsertSameObjects() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>(2);
        map.insert("Test1", "Test map");
        assertThat(map.insert("Test1", "Test map"), is(false));
    }

}