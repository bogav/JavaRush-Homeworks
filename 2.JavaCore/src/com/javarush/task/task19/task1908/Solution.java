package com.javarush.task.task19.task1908;

/* 
Выделяем числа
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

        int data, i = 1;
        while (in.ready()) {
            String[] sb = in.readLine().split(" ");
            for (int j = 0; j < sb.length; j++)
                try {
                    out.write(Integer.parseInt(sb[j]) + " ");
                } catch (NumberFormatException e) {
                }

        }
        in.close();
        out.close();

    }
}
