package ru.job4j.generic;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {

    @Test
    public void whenAdd() {
        MemStore mem = new MemStore();
        mem.add(new User("One", "UserName"));
        assertThat(mem.findById("One").getId(), is("One"));
    }

    @Test
    public void whenReplace() {
        MemStore mem = new MemStore();
        mem.add(new User("One", "UserName"));
        mem.replace("One", new User("Two", "UserName2"));
        assertThat(mem.findById("Two").getId(), is("Two"));
    }

    @Test
    public void delete() {
        MemStore mem = new MemStore();
        mem.add(new User("One", "UserName"));
        mem.delete("One");
        assertThat(mem.findIndexById("One"), is(-1));
    }

    @Test
    public void findById() {
        MemStore mem = new MemStore();
        mem.add(new User("One", "UserName"));
        assertThat(mem.findById("One").getId(), is("One"));
    }

    @Test
    public void findIndexById() {
        MemStore mem = new MemStore();
        mem.add(new User("One", "UserName"));
        int rsl = mem.findIndexById("One");
        assertThat(rsl, is(0));
    }
}