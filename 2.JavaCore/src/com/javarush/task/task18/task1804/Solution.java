package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        FileInputStream fileIn = new FileInputStream(fileName);
        int[] a = new int[256];
        int b = 0;
        while (fileIn.available() != 0 ) {
            b = fileIn.read();
            a[b]++;
        }
        fileIn.close();
        int min = 256;
        for (int i = 0; i < 256; i++) if ( (min > a[i])&&(a[i] != 0) ) min = a[i];
        for (int i = 0; i < 256; i++) if (min==a[i]) System.out.print(i + " ");
    }
}
