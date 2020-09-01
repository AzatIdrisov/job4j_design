package ru.job4j.it;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SimpleArrayTest {

    @Test
    public void whenAddNewItemShouldGetThisItem() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("test1");
        assertThat(array.get(0), is("test1"));
    }

    @Test (expected = IllegalStateException.class)
    public void whenAddItemsMoreThenArraySizeThenThrowExecption()  {
        SimpleArray<String> array = new SimpleArray<>(2);
        array.add("test1");
        array.add("test2");
        array.add("test3");
    }

    @Test
    public void whenSetNewItemShouldGetThisItem() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("test1");
        array.set(0, "test101");
        assertThat(array.get(0), is("test101"));
    }

    @Test
    public void whenRemoveInFirstPositionShouldGetFromSecondPosition() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("test1");
        array.add("test2");
        array.remove(0);
        assertThat(array.get(0), is("test2"));
    }

    @Test (expected =  IndexOutOfBoundsException.class)
    public void whenGetAndIndexIsBiggerThanCountThenThrowExecption() {
        SimpleArray<String> array = new SimpleArray<>(5);
        array.add("test1");
        array.get(2);
    }
}