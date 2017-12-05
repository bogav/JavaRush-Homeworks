package com.javarush.task.task19.task1906;

/* 
Четные байты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        FileReader in = new FileReader(f1);
        FileWriter out = new FileWriter(f2);

        int data, i = 1;
        while (in.ready()) {
            data = in.read();
            if ( (i%2) ==0 ) out.write(data);
            i++;
        }

        in.close();
        out.close();
    }
}
