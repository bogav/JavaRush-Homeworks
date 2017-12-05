package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException{
        String result;
        if (string==null||string.isEmpty()||(string.length()-string.replaceAll("\t","").length() < 2) ) throw new TooShortStringException();
        try {
            String[] s = string.split("\t");
            result = s[1];
        } catch (Exception e) {
            throw new TooShortStringException();
        }
        return result;
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
    }
}
