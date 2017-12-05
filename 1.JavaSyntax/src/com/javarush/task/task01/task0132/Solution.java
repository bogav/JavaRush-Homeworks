package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        int firstNumber, secondNumber, thirdNumber, tens, result;
        firstNumber = number / 100;
        secondNumber = (number - firstNumber * 100) / 10;
        tens = number / 10;
        thirdNumber = number - tens * 10;
        result = firstNumber + secondNumber + thirdNumber;
        return  result;
        //напишите тут ваш код
    }
}