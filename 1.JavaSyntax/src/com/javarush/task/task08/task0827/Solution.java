package com.javarush.task.task08.task0827;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {
        Date currentDate = new Date(date);
        long curDateLong = currentDate.getTime();
        Date begYearDate = new Date(currentDate.getYear(),0,0);
        long begYearDateLong = begYearDate.getTime();
        long countDay = (curDateLong - begYearDateLong) / (1000 * 60 * 60 * 24);
        return !(countDay%2 == 0);
    }
}
