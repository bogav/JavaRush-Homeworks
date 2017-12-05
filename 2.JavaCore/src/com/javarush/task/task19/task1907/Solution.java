package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(f));

        int count = 0;
        while (in.ready()) {
            String[] sb = in.readLine().split("\\W");
            for (int j = 0; j < sb.length; j++)
                if (sb[j].equals("world")) count++;
        }
        in.close();

        System.out.println(count);

    }
}
