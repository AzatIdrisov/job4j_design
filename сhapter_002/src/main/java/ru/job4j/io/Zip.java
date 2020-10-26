package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<File> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            for (File file : sources) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<File> getFilesForPacking(Path directory, String excludedFiles) {
        List<File> files = new ArrayList<>();
        try {
            Search.search(directory, f -> !f.getName().endsWith(excludedFiles))
                    .forEach(f -> files.add(f.toFile()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return files;
    }

    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(
                new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgZip zipArguments = new ArgZip(args);
        if (zipArguments.valid()) {
            Zip zip = new Zip();
            List<File> files = zip.getFilesForPacking(Paths.get(zipArguments.directory()),
                    zipArguments.exclude());
            zip.packFiles(files, new File(zipArguments.output()));
        }
    }
}