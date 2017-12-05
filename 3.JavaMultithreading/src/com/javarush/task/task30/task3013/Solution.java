package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = Integer.MAX_VALUE - 1234567890;
        System.out.println(Integer.toString(number, 2));

        int tmp = solution.resetLowerBits(number);
        String result = Integer.toString(tmp, 2);
        System.out.println(result);
        System.out.println(tmp);
    }

    public int resetLowerBits(int number) {
        number &= (~number >> 1);
        number &= (~number >> 2);
        number &= (~number >> 4);
        number &= (~number >> 8);
        number &= (~number >> 16);
        return number;
    }
}