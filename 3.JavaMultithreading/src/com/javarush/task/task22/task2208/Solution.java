package com.javarush.task.task22.task2208;

import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry m : params.entrySet()) {
            if (m.getValue() != null) {
                if (sb.length() > 0) sb.append(" and ");
                sb.append(m.getKey() + " = '" + m.getValue() + "'");
            }
        }
        return sb.toString();
    }
}
