package ru.job4j.io;

import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DuplicateFinderTest {

    @Test
    public void whenHaveCopy() {
        Path path = Paths.get("./data");
        List<String> rsl = DuplicateFinder.findDuplicate(path);
        assertThat(rsl.size(), is(1));
    }

}