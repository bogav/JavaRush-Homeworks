package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String f1 = reader.readLine();
        String f2 = reader.readLine();
        reader.close();

        BufferedReader in = new BufferedReader(new FileReader(f1));
        BufferedWriter out = new BufferedWriter(new FileWriter(f2));

        while (in.ready()) {
            String sb = in.readLine();
            sb = sb.replace(".", "!");
            out.write(sb.toCharArray());
        }
        in.close();
        out.close();
    }
}
