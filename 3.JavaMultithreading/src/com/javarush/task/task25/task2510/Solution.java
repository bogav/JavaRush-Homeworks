package com.javarush.task.task25.task2510;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() {
        this.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread thread, Throwable e) {
                if ( e instanceof Exception) {
                    System.out.println("Надо обработать");
                    return;
                }

                if (e instanceof Error) {
                    System.out.println("Нельзя дальше работать");
                    return;
                }

                if (e instanceof Throwable) {
                    System.out.println("ХЗ");
                    return;
                }

            }

        });
    }

    public static void main(String[] args) {
    }
}
