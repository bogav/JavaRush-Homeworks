package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //Initialize
        String s = "";
        ArrayList<String> list = new ArrayList<String>();
        //ввод строк с клавиатуры
        for (int i = 0; i < 10; i++)
        {
            list.add(reader.readLine());
            if (s.length() > list.get(i).length()) {
                System.out.println(i);
                break;
            }
            s = list.get(i);
        }//напишите тут ваш код
    }
}

