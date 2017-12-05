package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException{
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        List<ReadThread> arrayList = new ArrayList<ReadThread>();
        String is = bis.readLine();

        while (!is.equals("exit")) {
            ReadThread readThread = new ReadThread(is);
            readThread.start();
            arrayList.add(readThread);
            is = bis.readLine();
        }

        for (ReadThread item: arrayList) {
            item.join();
        }
    }

    public static class ReadThread extends Thread {
        private String name;
        private FileInputStream file;

        public ReadThread(String fileName) throws FileNotFoundException{
            //implement constructor body
            file = new FileInputStream(fileName);
            this.name = fileName;
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {  //Этот метод будет выполнен в побочном потоке
            int[] chars = new int[(int)Character.MAX_VALUE];

            try {
                while (file.available() > 0)
                    chars[file.read()]++;
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            int[] maxChar = new int[]{0, 0};
            for (int i = 0; i < chars.length; i++)
                if (maxChar[1] < chars[i]) {
                maxChar[0] = i;
                maxChar[1] = chars[i];
            }

            resultMap.put(name, maxChar[0]);
        }
    }
}
