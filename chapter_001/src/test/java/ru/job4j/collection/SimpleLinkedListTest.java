package ru.job4j.collection;

import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleLinkedListTest {

    @Test
    public void whenAdd() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        String rsl = list.get(2);
        assertThat(rsl, is("third"));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetEmpty() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.get(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenGetOutBound() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("first");
        list.get(1);
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("first");
        Iterator<String> it = list.iterator();
        list.add("second");
        it.next();
    }

    @Test
    public void whenMultipleNext() {
        SimpleLinkedList<String> list = new SimpleLinkedList<>();
        list.add("first");
        Iterator<String> it = list.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
    }
}