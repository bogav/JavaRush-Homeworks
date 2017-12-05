package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) {
        //...
        try (BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader reader = new BufferedReader(new FileReader(r.readLine()));) {
            StringBuilder sb = new StringBuilder();
            String s;
            while ((s = reader.readLine()) != null)
                sb.append(s).append(" ");
            String[] words = sb.toString().split(" ");
            StringBuilder result = getLine(words);
            System.out.println(result.toString());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static StringBuilder getLine(String... words) {
        if (words.length == 0) return new StringBuilder();

        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);


//----------- добавляем наши слова в список
        List<String> list = new ArrayList<String>();
        for(String e : words){
            list.add(e);
        }

        boolean isCorrect;


        while (true){
            Collections.shuffle(list);
            isCorrect = true;
//-----------проверка правильной последовательности
            for(int i = 0; i < list.size(); i++){
                if(i+1 != list.size()){
                    if(!list.get(i).substring(list.get(i).length()-1).toLowerCase().equals(list.get(i+1).substring(0, 1).toLowerCase())){
                        isCorrect = false;
                        break;
                    }
                }
            }
            if(isCorrect)
                break;

        }
//----------создаем наш возвращаемый объект
        StringBuilder sb = new StringBuilder("");
        sb.append(list.get(0));

        for(int i = 1; i < list.size(); i++){
            sb.append(" "+list.get(i));
        }

        return sb;

    }

}
