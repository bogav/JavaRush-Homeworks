package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.lang.String;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Initialize
        int shr = 0, lng = 0;
        ArrayList<String> list = new ArrayList<String>();
        //ввод строк с клавиатуры
        for (int i = 0; i < 10; i++)
        {
            String s = reader.readLine();
            list.add(s);
            if (s.length() > list.get(lng).length()) lng = i;
            if (s.length() < list.get(shr).length()) shr = i;
        }//напишите тут ваш код

        if (lng < shr) System.out.print(list.get(lng)); else System.out.print(list.get(shr));
    }
}
