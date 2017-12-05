package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Date d = sdf.parse(reader.readLine());
        sdf = new SimpleDateFormat("MMM dd, yyyy", Locale.ENGLISH);
        System.out.println(sdf.format(d).toUpperCase());
    }
}
