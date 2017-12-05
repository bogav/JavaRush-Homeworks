
package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 0;
        while (!currentThread.isInterrupted()) {
            try {
                String s = String.valueOf(++i);
                map.put(s, "Some text for " + s);
                Thread.sleep(500);
            }catch (Exception e){
                System.out.println("[" + currentThread.getName().toString() + "] thread was terminated");
            }
        }
    }
}