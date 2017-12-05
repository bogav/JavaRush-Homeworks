package com.javarush.task.task08.task0818;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> SalaryList = new HashMap<String, Integer>();//напишите тут ваш код
        SalaryList.put("qwe", 345);
        SalaryList.put("wer", 785);
        SalaryList.put("qrt", 345);
        SalaryList.put("tyu", 743);
        SalaryList.put("uio", 463);
        SalaryList.put("iop", 256);
        SalaryList.put("asd", 886);
        SalaryList.put("dfg", 787);
        SalaryList.put("ghj", 345);
        SalaryList.put("jkl", 235);

        return SalaryList;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator i = map.entrySet().iterator();
        while(i.hasNext()) {
            Map.Entry q = (Map.Entry) i.next();
            if ((int)q.getValue() < 500) {
                //if (Integer.parseInt(q.getValue().toString()) < 500) {
                map.remove(q.getKey()); i = map.entrySet().iterator();
            }
        }

        //напишите тут ваш код
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = createMap();
        removeItemFromMap(map);
        System.out.println(map.size());
    }
}