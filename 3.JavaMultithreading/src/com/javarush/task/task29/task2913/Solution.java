package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String s = "";
        if (a < b) {
            s = Integer.toString(a);
            for (int i = a+1; i <= b; i++)
                s += " " + Integer.toString(i);
        } else
            if (a == b) {
                s = Integer.toString(a);
            } else {
            s = Integer.toString(a);
            for (int i = a-1; i >= b; i--)
                s += " " + Integer.toString(i);
        }
        return s;
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt() % 1_000;
        numberB = random.nextInt() % 10_000;
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}