package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException{
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner freader = new Scanner(new FileInputStream(reader.readLine()));
        ArrayList<Integer> arrayList = new ArrayList<Integer>();

        while ( freader.hasNext() ){
            int i = Integer.parseInt( freader.next() );
            if ( i%2 == 0) arrayList.add(i);
        }

        Collections.sort(arrayList);
        for (Integer i : arrayList){
            System.out.println(i + " ");
        }

        freader.close(); reader.close();
    }
}
