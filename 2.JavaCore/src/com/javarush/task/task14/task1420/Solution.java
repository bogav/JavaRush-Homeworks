package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pos1 = 0, pos2 = 0;
        pos1 = Integer.parseInt(reader.readLine());
        pos2 = Integer.parseInt(reader.readLine());

        if (pos1 <= 0 || pos2 <= 0){ throw new Exception(); }

        //int nod = 1;
          //  for (int i = 1; i < pos1; i++)
            //    if ( (pos1%i == 0)&&(pos2%i == 0) ) nod = i;

        while (pos1 != pos2) { if (pos1 > pos2) pos1 = pos1 - pos2; else pos2 = pos2 - pos1; }
        System.out.println(pos1);
    }
}
