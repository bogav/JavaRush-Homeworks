package com.javarush.task.task22.task2202;

/**
 * Created by Admin on 7.06.2017.
 */
public class TooShortStringException extends RuntimeException {
    public TooShortStringException(Throwable throwable) {
        super(throwable);
    }
}
