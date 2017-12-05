package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream inputStream = new FileInputStream(reader.readLine());
        // Создаем поток-записи-байт-в-файл
        //FileOutputStream outputStream = new FileOutputStream("c:/result.txt");
        int count = 0, a = 0;
        while (inputStream.available() > 0) {
            //читаем весь файл одним куском
            //byte[] buffer = new byte[inputStream.available()];

            if ( (char)inputStream.read() == ',') count++;
            //int count = inputStream.read(buffer);
            //outputStream.write(buffer);
        }
        System.out.println(count);

        inputStream.close();
        //outputStream.close();

    }
}
