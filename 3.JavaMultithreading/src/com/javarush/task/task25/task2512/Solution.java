package com.javarush.task.task25.task2512;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();

        List<Throwable> throwables = new ArrayList<Throwable>();
        Throwable tmp = e;
        while (tmp != null) {
            throwables.add(tmp);
            tmp = tmp.getCause();
        }
        Collections.reverse(throwables);
        for (Throwable item: throwables) {
            System.out.println(item.toString());
        }
    }

    public static void main(String[] args) {
        Thread t = new Thread(new Runnable()
        {
            public void run(){
                //System.out.println("Thread ...  started");
                throw new RuntimeException("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));

            }

        });

        t.setUncaughtExceptionHandler(new Solution());
        t.start();

    }
}
