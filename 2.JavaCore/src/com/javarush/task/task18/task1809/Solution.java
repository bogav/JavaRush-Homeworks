package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s1 = reader.readLine(), s2 = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s1);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream = new FileOutputStream(s2);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        byte tmp = 0;
        for (int i = 0; i < buffer.length/2; i++) {
            tmp = buffer[i];
            buffer[i] = buffer[buffer.length-i-1];
            buffer[buffer.length-i-1] = tmp;
        }
        outputStream.write(buffer);

        inputStream.close();
        outputStream.close();

    }
}
