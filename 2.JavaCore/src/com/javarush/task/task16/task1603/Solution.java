package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {
        List<SpecialThread> spelist = new ArrayList<SpecialThread>();
        for (int i = 0; i < 5; i++) {
            spelist.add(new SpecialThread());
            list.add(new Thread(spelist.get(i)));
            //list.get(i).run();
        }//Add your code here - добавьте свой код тут
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
