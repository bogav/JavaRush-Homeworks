package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread item : threads) {
            switch (item.getState() ) {
                case NEW:item.start(); break;
                case WAITING:
                case BLOCKED:
                case TIMED_WAITING:item.interrupt(); break;
                case RUNNABLE:item.isInterrupted(); break;
                case TERMINATED: System.out.println(item.getPriority());
            }
        }
    }

    public static void main(String[] args) {
    }
}
