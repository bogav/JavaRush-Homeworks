package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        //int indexA = string.indexOf(" ");
        //int indexB = string.indexOf(" ", 4);
        String result;
        try {
            String[] s = string.split(" ");
            result = s[1] + " " + s[2] + " " + s[3] + " " + s[4];
        } catch (Exception e) {
            throw new TooShortStringException(e);
        }
        return result;
    }

    public static class TooShortStringException extends RuntimeException{
        public TooShortStringException(Throwable throwable) {
            super(throwable);
        }
    }
}
