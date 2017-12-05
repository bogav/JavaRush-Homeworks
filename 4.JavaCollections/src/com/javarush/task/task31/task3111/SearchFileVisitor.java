package com.javarush.task.task31.task3111;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class SearchFileVisitor extends SimpleFileVisitor<Path> {
    private String partOfName;
    private String partOfContent;
    private int minSize = 0;
    private int maxSize = 0;
    private List<Path> foundFiles = new ArrayList<>();

    public void setPartOfName(String partOfName) {
        this.partOfName = partOfName;
    }

    public void setPartOfContent(String partOfContent) {
        this.partOfContent = partOfContent;
    }

    public void setMinSize(int minSize){
        this.minSize = minSize;
    }

    public void setMaxSize(int maxSize){
        this.maxSize = maxSize;
    }

    public List<Path> getFoundFiles() {
        return foundFiles;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        if ((partOfName == null || file.getFileName().toString().contains(partOfName)) &&
                (minSize == 0 || Files.size(file) > minSize) &&
                (maxSize == 0 || Files.size(file) < maxSize) &&
                (partOfContent == null ||
                        new String(Files.readAllBytes(file)).contains(partOfContent))) {
            foundFiles.add(file);
        }
        return FileVisitResult.CONTINUE;
    }

}
