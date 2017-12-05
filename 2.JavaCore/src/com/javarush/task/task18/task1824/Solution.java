package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException{
        List<BufferedReader> arrbis = new ArrayList<BufferedReader>();
        String name = "";
        while (true)
        try{
            name = (new BufferedReader(new InputStreamReader(System.in))).readLine();
            BufferedReader bis = new BufferedReader(new InputStreamReader(new FileInputStream(name)));
            arrbis.add(bis);
        } catch (Exception e) {
            System.out.println(name);
            for (BufferedReader item: arrbis )
                item.close();
            return;
        }
    }
}
