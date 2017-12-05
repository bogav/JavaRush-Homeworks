package com.javarush.task.task31.task3101;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Проход по дереву файлов
*/
public class Solution {
    public static void main(String[] args) throws IOException{
        String path = args[0];
        File resultFile = new File(args[1]);
        String allFilesContent = resultFile.getParent()+"/allFilesContent.txt";
        FileUtils.renameFile(resultFile, new File(allFilesContent));

        final List<File> files = new ArrayList<>();
        Path pathDir = Paths.get(path);

        FileOutputStream outputStream = new FileOutputStream(allFilesContent);

        Files.walkFileTree(pathDir, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file,
                                             BasicFileAttributes fileAttributes) throws IOException {
                if (Files.size(file) > 50) {
                    FileUtils.deleteFile(new File(file.toAbsolutePath().toString()));
                } else {
                    files.add(file.toFile());
                }
                return FileVisitResult.CONTINUE;
            }
        });
        Collections.sort(files, new Comparator<File>() {
            public int compare(File o1, File o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Files.copy(files.get(0).toPath(), outputStream);
        for (int i = 1; i < files.size(); i++) {
            outputStream.write(System.lineSeparator().getBytes());
            Files.copy(files.get(i).toPath(), outputStream);
        }
        outputStream.write(System.lineSeparator().getBytes());
        outputStream.close();
    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }
}
