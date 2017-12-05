package com.javarush.task.task08.task0822;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Iterator;

/* 
Минимальное из N чисел
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        List<Integer> integerList = getIntegerList();
        System.out.println(getMinimum(integerList));
    }

    public static int getMinimum(List<Integer> array) {

        int res = array.get(0);
        Iterator iterator = array.iterator();

        for (int i = 1; i < array.size(); i++) if ( res > array.get(i) ) res = array.get(i);
        //while ( iterator.hasNext() ) if ( (int)iterator.next() < res) res = (int)iterator.next(); // find minimum here — найти минимум тут
        return res;
    }

    public static List<Integer> getIntegerList() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in) );
        int num = Integer.parseInt( reader.readLine() );//create and initialize a list here - создать и заполнить список тут

        List<Integer> intList = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) intList.add( Integer.parseInt( reader.readLine() ) );
        return intList;
    }
}
