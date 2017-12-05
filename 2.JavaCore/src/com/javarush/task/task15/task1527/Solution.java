package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Pattern;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //add your code here
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        String key = reader.readLine();
        String[] list = key.split(Pattern.quote("?") );
        list = list[1].split("&");
        String value = null;
        for (int i = 0; i < list.length; i++) {
            if (list[i].split("=")[0].equals("obj")) {
                value = list[i].split("=")[1];
            }
            System.out.print(list[i].split("=")[0]+ " ");
        }
        System.out.println();
        if (value != null) {
            try {
                alert(Double.parseDouble(value));
            } catch (Exception e) {
                alert(value);
            }
        }

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
