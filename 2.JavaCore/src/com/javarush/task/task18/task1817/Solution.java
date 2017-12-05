package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.nio.CharBuffer;

public class Solution {
    public static void main(String[] args) throws IOException{
        FileInputStream fileInputStream = new FileInputStream(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
        int tmp;
        float totalAmount = 0, spaceAmount = 0;
        while (reader.ready()) {
            tmp = reader.read();
            if (tmp == 32) spaceAmount++;
            totalAmount++;
        }
        reader.close();
        double result = (double) spaceAmount/totalAmount * 100;
        System.out.println(String.format("%.2f",result));

    }
}
