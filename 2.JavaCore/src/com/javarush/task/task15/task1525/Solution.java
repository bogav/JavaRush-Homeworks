package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {
        try {
            Scanner reader = new Scanner(new FileReader(Statics.FILE_NAME));
            while (reader.hasNext())
                lines.add(reader.nextLine());
        } catch (IOException e){}
    }

    public static void main(String[] args) throws IOException{
        System.out.println(lines);
    }
}
