package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        InputStreamReader in = new InputStreamReader(System.in);
        BufferedReader buff = new BufferedReader(in);
        float summ = 0;
        int count = 0;
        while (true) {
            int num = Integer.parseInt(buff.readLine());
            if (num != -1) { summ += num; count ++; } else break;
        }
        System.out.println(summ/count);
        //напишите тут ваш код
    }
}

