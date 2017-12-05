package com.javarush.task.task31.task3113;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/* 
Что внутри папки?
*/
public class Solution {
    static long aFolders = 0;
    static long aFiles = 0;
    static long aSize = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        Path folder = Paths.get(is.readLine());
        is.close();

        if (!Files.isDirectory(folder)) {
            System.out.println(folder.toAbsolutePath().toString() + " - не папка");
            return;
        }

        Files.walkFileTree(folder, new MyVisitor());
        //aFolders--;

        System.out.println("Всего папок - " + aFolders);
        System.out.println("Всего файлов - " + aFiles);
        System.out.println("Общий размер - " + aSize);
    }

    public static class MyVisitor extends SimpleFileVisitor {
        @Override
        public FileVisitResult visitFile(Object o, BasicFileAttributes basicFileAttributes) throws IOException {
            aFiles++;
            aSize += basicFileAttributes.size();
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Object o, IOException e) throws IOException {
            aFolders++;
            return FileVisitResult.CONTINUE;
        }
    }
}
