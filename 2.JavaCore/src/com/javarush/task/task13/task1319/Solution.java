package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Запись в файл с консоли
*/

public class Solution {
    public static void main (String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)) ;
        String s = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new FileWriter(s) );

        do {
            s = reader.readLine();
            writer.write(s); writer.newLine();
        } while (!"exit".equals(s) );

        writer.close();
        // напишите тут ваш код
    }
}
