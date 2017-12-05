package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileIn = new FileInputStream(fileName);
        int a = 0, b = 0;
        if (fileIn.available() !=0) a = fileIn.read();
        while (fileIn.available() != 0 ) {
            b = fileIn.read();
            if (a<b) a = b;
        }
        fileIn.close();
        System.out.println(a);
    }
}
