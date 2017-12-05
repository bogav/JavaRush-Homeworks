package com.javarush.task.task22.task2210;

import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        getTokens("level22.lesson13.task01", ".");
    }
    public static String [] getTokens(String query, String delimiter) {
        StringTokenizer st = new StringTokenizer(query, delimiter);
        int count = st.countTokens();
        String[] token = new String[count];
        for (int i = 0; i < count; i++) {
            token[i] = st.nextToken();
        }
        return token;
    }
}
