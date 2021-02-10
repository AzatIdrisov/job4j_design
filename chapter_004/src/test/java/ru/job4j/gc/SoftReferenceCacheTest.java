package ru.job4j.gc;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class SoftReferenceCacheTest {

    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void getFromCache() throws IOException {
        File file = folder.newFile("Test1");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Hello world!");
        }
        String exp = System.lineSeparator() + "Hello world!";
        String rsl = new SoftReferenceCache().get(file.getAbsolutePath());
        assertThat(rsl, is(exp));
    }

    @Test
    public void addToCacheAndGet() throws IOException {
        File file = folder.newFile("Test1");
        try (PrintWriter out = new PrintWriter(file)) {
            out.println("Hello world!");
        }
        String exp = System.lineSeparator() + "Hello world!";
        SoftReferenceCache cache = new SoftReferenceCache();
        cache.load(file.getAbsolutePath());
        String rsl = cache.get(file.getAbsolutePath());
        assertThat(rsl, is(exp));
    }

}