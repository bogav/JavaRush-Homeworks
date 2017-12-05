package com.javarush.task.task09.task0918;

/* 
Все свои, даже исключения
*/

import jdk.jfr.events.ExceptionThrownEvent;

import java.io.IOException;

public class Solution {
    public static void main(String[] args) {
    }
    
    static class MyException extends ClassNotFoundException{
    }

    static class MyException2 extends IOException{
    }

    static class MyException3 extends OutOfMemoryError{
    }

    static class MyException4 extends StackOverflowError{
    }
}

