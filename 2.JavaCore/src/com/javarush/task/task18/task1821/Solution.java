package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        int[] chars = new int[(int)Character.MAX_VALUE];
        FileInputStream fileInputStream = new FileInputStream(args[0]);

        while (fileInputStream.available() > 0)
            chars[fileInputStream.read()]++;

        fileInputStream.close();

        for (int i = 0; i < (int)Character.MAX_VALUE; i++) {
            if (chars[i] > 0 ) System.out.println((char)i + " " + chars[i]);
        }
    }
}
