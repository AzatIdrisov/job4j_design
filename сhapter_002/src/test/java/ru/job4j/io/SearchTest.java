package ru.job4j.io;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SearchTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenDirectoryHaveOneJSFile() throws IOException {
        File source = folder.newFile("test.js");
        Path path = source.toPath();
        List<Path> rsl = Search.search(path, file -> file.getName().endsWith(".js"));
        assertThat(rsl.size(), is(1));
    }

    @Test
    public void whenDirectoryHaveNotJSFile() throws IOException {
        File source = folder.newFile("test.txt");
        Path path = source.toPath();
        List<Path> rsl = Search.search(path, file -> file.getName().endsWith(".js"));
        assertThat(rsl.size(), is(0));
    }
}