package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> dList = new ArrayList<String>();
        Path pathDir = Paths.get(root);

            Files.walkFileTree(pathDir, new SimpleFileVisitor<Path>() {
                public FileVisitResult visitFile(Path file,
                                                 BasicFileAttributes fileAttributes) throws IOException {
                        dList.add(file.toFile().getAbsolutePath());
                    return FileVisitResult.CONTINUE;
                }
            });

        return dList;
    }

    public static void main(String[] args) {
        
    }
}
