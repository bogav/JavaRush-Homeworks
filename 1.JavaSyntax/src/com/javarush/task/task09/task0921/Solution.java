package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> arrlist = new ArrayList<Integer>();

        try {
            while (true) {
                arrlist.add(Integer.parseInt( (new BufferedReader(new InputStreamReader(System.in))).readLine() ));
            }
        } catch (Exception e) {
            for (int i = 0; i < arrlist.size(); i++) {
                System.out.println(arrlist.get(i));
            }
        }
    }
}
