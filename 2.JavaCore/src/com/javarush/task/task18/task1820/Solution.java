package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.nio.CharBuffer;

public class Solution {
    public static void main(String[] args) throws IOException{
        String fileOut, fileIn;
        fileIn = new BufferedReader(new InputStreamReader(System.in)).readLine();
        fileOut = new BufferedReader(new InputStreamReader(System.in)).readLine();
        FileInputStream fileReader = new FileInputStream(fileIn);
        FileOutputStream fileWriter = new FileOutputStream(fileOut);

        StringBuilder str = new StringBuilder();
        while (fileReader.available() > 0) {
            str.append(Character.toChars(fileReader.read()));
        }
        String[] numbers = str.toString().split(" ");
        for (int i = 0; i < numbers.length; i++) {
            int digit = Math.round(Float.parseFloat(numbers[i]));
            fileWriter.write(Integer.toString(digit).getBytes());
            fileWriter.write(32);
        }
        fileReader.close();
        fileWriter.close();

        /*StringBuffer strings = new StringBuffer(fileIn.length());
        string.
        fileReader.read(strings);
        while (reader.ready()) {
            tmp = reader.read();
            if (tmp == 32) spaceAmount++;
            totalAmount++;
        }
        reader.close();
        double result = (double) spaceAmount/totalAmount * 100;
        System.out.println(String.format("%.2f",result)); */
    }
}
