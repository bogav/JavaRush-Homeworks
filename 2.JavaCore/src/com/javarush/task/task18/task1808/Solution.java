package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] s = new String[3];
        for (int i = 0; i < 3; i++) s[i] = reader.readLine();
        FileInputStream inputStream = new FileInputStream(s[0]);
        // Создаем поток-записи-байт-в-файл
        FileOutputStream outputStream2 = new FileOutputStream(s[1]);
        FileOutputStream outputStream3 = new FileOutputStream(s[2]);

        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        outputStream3.write(buffer, (int)( (buffer.length + 1)/ 2) , (int)(buffer.length / 2));
        outputStream2.write(buffer, 0, (int)( (buffer.length + 1) / 2) );

        inputStream.close();
        outputStream2.close();
        outputStream3.close();

    }
}
