package com.javarush.task.task14.task1421;

/**
 * Created by Admin on 3.05.2017.
 */
public class Singleton {
    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        //if (instance.equals(null)) instance = new Singleton();
        return instance;
    }
}
