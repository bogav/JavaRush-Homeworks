package com.javarush.task.task08.task0828;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/* 
Номер месяца
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();//напишите тут ваш код

        HashMap<String, Integer> m=new HashMap<String, Integer>();
        m.put("January",1);
        m.put("February",2);
        m.put("March",3);
        m.put("April",4);
        m.put("May",5);
        m.put("June",6);
        m.put("July",7);
        m.put("August",8);
        m.put("September",9);
        m.put("October",10);
        m.put("November",11);
        m.put("December",12);
        for (HashMap.Entry<String, Integer> st : m.entrySet() )
            if(st.getKey().equals(s))
                System.out.println(st.getKey()+" is "+st.getValue()+" month");
    }
}
