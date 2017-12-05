package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        char[] letter = s.toCharArray();
        letter[0] = Character.toUpperCase(letter[0]);

        for (int i = 1; i < letter.length; i++)
            if (Character.isLetter(letter[i])&&(letter[i-1]==(char)' ') )
                letter[i] = Character.toUpperCase(letter[i]);

        System.out.print(letter);

        //напишите тут ваш код
    }
}
