package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        HashMap<String, Integer> m = new HashMap<String, Integer>();
        String id = reader.readLine();
        String name = null;
        while (!id.equals("")) {
            name = reader.readLine();
            m.put(name,Integer.parseInt(id));
            id = reader.readLine();
        }
        for (HashMap.Entry<String, Integer> entry : m.entrySet()) {
            System.out.println(entry.getValue() + " " + entry.getKey());
        }

    }
}
