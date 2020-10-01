package ru.job4j.collection;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class AnalizeTest {

    @Test
    public void whenDelete1AndAddNew1() {
        Analize analize = new Analize();
        List<Analize.User> prev = List.of(new Analize.User(1, "Azat"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Maksim"));
        List<Analize.User> current = List.of(new Analize.User(1, "Azat"),
                new Analize.User(2, "Alex"),
                new Analize.User(4, "Nick"));
        Analize.Info info = analize.diff(prev, current);
        assertThat(info.getAdded(), is(1));
        assertThat(info.getChanged(), is(1));
        assertThat(info.getDeleted(), is(1));
    }

    @Test
    public void whenNotDifference() {
        Analize analize = new Analize();
        List<Analize.User> prev = List.of(new Analize.User(1, "Azat"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Maksim"));
        List<Analize.User> current = List.of(new Analize.User(1, "Azat"),
                new Analize.User(2, "Petr"),
                new Analize.User(3, "Maksim"));
        Analize.Info info = analize.diff(prev, current);
        assertThat(info.getAdded(), is(0));
        assertThat(info.getChanged(), is(0));
        assertThat(info.getDeleted(), is(0));
    }

}