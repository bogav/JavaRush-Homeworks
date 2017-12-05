package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();

        FileInputStream in2 = new FileInputStream(f1);
        byte[] b2 = new byte[in2.available()];
        in2.read(b2);
        in2.close();

        FileInputStream in1 = new FileInputStream(f2);
        byte[] b1 = new byte[in1.available()];
        in1.read(b1);
        in1.close();

        FileOutputStream out = new FileOutputStream(f1);
        out.write(b1);
        out.write(b2);
        out.close();
    }
}
