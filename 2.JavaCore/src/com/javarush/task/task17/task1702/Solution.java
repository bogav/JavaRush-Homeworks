package com.javarush.task.task17.task1702;

import java.util.*;

/* 
Вместе быстрее? Ща проверим :)
*/

public class Solution {
    public static int countThreads = 10;
    public static int[] testArray = new int[1000];

    static {
        for (int i = 0; i < Solution.testArray.length; i++) {
            testArray[i] = i;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long timer = new Date().getTime();

        StringBuffer expectedResult = new StringBuffer();
        for (int i = 1000 - 1; i >= 0; i--) {
            expectedResult.append(i).append(" ");
        }

        initThreads();

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < testArray.length; i++) {
            result.append(testArray[i]).append(" ");
        }
        System.out.println(result);
        System.out.println((result.toString()).equals(expectedResult.toString()));
        System.out.println(new Date().getTime() - timer);
    }

    public static class SortThread extends Thread {
        public void run(){
            sort(testArray);
        }
    }

    public static void initThreads() throws InterruptedException {
        List<Thread> threads = new ArrayList<Thread>(countThreads);
        for (int i = 0; i < countThreads; i++) threads.add(new SortThread());
        for (Thread thread : threads) { thread.start(); Thread.sleep(3);}
        for (Thread thread : threads) thread.join();
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] < array[j]) {
                    int k = array[i];
                    array[i] = array[j];
                    array[j] = k;
                }
            }
        }
    }
}

