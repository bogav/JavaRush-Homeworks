package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        String f3 = reader.readLine();

        FileOutputStream out = new FileOutputStream(f1);
        FileInputStream in1 = new FileInputStream(f2);
        FileInputStream in2 = new FileInputStream(f3);

        byte[] b1 = new byte[in1.available()];
        byte[] b2 = new byte[in2.available()];

        in1.read(b1);
        in2.read(b2);

        out.write(b1);
        out.write(b2);

        out.close();
        in1.close();
        in2.close();
    }
}
