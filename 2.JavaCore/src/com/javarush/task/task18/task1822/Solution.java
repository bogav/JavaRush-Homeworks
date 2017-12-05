package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String ifile = reader.readLine();
        reader.close();

        BufferedReader br = new BufferedReader(new FileReader(ifile));
        while (br.ready()) {
            String s = br.readLine();
            String[] arrs = s.split(" ");
            if (Integer.parseInt(args[0]) == Integer.parseInt(arrs[0])) {
                System.out.println(s);
                br.close();
                return;
            }
        }
    }
}
