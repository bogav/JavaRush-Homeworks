package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(f1));
        BufferedWriter out = new BufferedWriter(new FileWriter(f2));

        StringBuffer sb = new StringBuffer();

        String s;
        while ((s=in.readLine())!=null) {
            sb.append(s);
        }

        out.write(sb.toString().replaceAll("[\\p{Punct}\\n]",""));

        in.close();
        out.close();

    }
}
