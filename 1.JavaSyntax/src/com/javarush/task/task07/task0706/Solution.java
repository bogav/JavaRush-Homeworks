package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] flats = new int[15];
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int odd = 0, even = 0;
        for (int i = 0; i < 15; i++) {
            flats[i] = Integer.parseInt(reader.readLine());
            if ((i % 2) == 0) odd += flats[i]; else even += flats[i];
        }
        System.out.print("В домах с ");
        if (odd>even) System.out.print("четными"); else System.out.print("нечетными");
        System.out.println(" номерами проживает больше жителей.");
        //напишите тут ваш код
    }
}
