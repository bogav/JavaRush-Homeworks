package com.javarush.task.task18.task1810;

/* 
DownloadException
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws DownloadException, IOException {
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        FileInputStream fileInputStream = new FileInputStream(filename);
        while(fileInputStream.available()>=1000) {
            filename = scanner.next();
            fileInputStream=new FileInputStream(filename); }
            throw new DownloadException();
    }

    public static class DownloadException extends Exception {

    }
}
