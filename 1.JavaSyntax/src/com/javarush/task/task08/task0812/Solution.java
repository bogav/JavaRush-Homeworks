package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<Integer> num = new ArrayList<Integer>();//напишите тут ваш код
        for (int i = 0; i < 10; i++) num.add(Integer.parseInt(reader.readLine()));

        int max_len = 1, count = 1;
        for (int i = 0; i < num.size() - 1 ; i++) {
            if(num.get(i) == num.get(i + 1)){
                count++;
                if(max_len < count) max_len = count;
            } else count = 1;
        } System.out.println(max_len);

    }
}