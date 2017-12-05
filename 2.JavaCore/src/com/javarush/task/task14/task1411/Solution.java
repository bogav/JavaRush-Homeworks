package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        key = reader.readLine();
        //тут цикл по чтению ключей, пункт 1
        while ( "user".equals(key)||"loser".equals(key)||"coder".equals(key)||"proger".equals(key) )
        {
            //создаем объект, пункт 2
            if ("user".equals(key)) person = new Person.User();
            if ("loser".equals(key)) person = new Person.Loser();
            if ("coder".equals(key)) person = new Person.Coder();
            if ("proger".equals(key)) person = new Person.Proger();

            doWork(person); //вызываем doWork
            key = reader.readLine();
        }
    }

    public static void doWork(Person person) {
        // пункт 3
        if (person instanceof Person.User) ((Person.User) person).live();
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();

    }
}
