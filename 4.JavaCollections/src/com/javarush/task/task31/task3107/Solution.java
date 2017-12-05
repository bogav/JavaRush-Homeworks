package com.javarush.task.task31.task3107;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
Null Object Pattern
*/
public class Solution {
    private FileData fileData;

    public Solution(String pathToFile) {
        Path myFile = Paths.get(pathToFile);
        try {
            fileData = new ConcreteFileData(Files.isHidden(myFile), Files.isExecutable(myFile),
                    Files.isDirectory(myFile), Files.isWritable(myFile));
        }catch (Exception e) {
            fileData = new NullFileData(e);
        }
    }

    public FileData getFileData() {
        return fileData;
    }
}
