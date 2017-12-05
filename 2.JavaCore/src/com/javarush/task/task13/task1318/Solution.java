package com.javarush.task.task13.task1318;

import java.io.*;
import java.util.Scanner;

/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader sreader = new BufferedReader(new InputStreamReader(System.in));
        String filename = sreader.readLine();

        InputStream inputStream = new FileInputStream(filename);
        while (inputStream.available()>0){
            System.out.print((char)inputStream.read());
        }

        inputStream.close();
        sreader.close();
        System.out.println();    /*  BufferedReader freader = new BufferedReader(new FileReader(name));

        String data = null;
        while ( (data = freader.readLine() ) !=null)
        {
            System.out.println(data); //записываем прочитанный байт в другой поток.
        }

        freader.close(); //закрываем потоки
        sreader.close();
    */
        // напишите тут ваш код
    }
}