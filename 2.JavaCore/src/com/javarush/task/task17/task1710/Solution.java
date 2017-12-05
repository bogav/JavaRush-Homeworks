package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        //start here - начни тут
        //String[] list = args.split(Pattern.quote(" "));
        try {
            switch (args[0]) {
            case "-c" :
                Person P2 = null;
                if (args[2].equals("ж"))
                    P2 = Person.createFemale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                else P2 = Person.createMale(args[1], new SimpleDateFormat("dd/MM/yyyy").parse(args[3]));
                allPeople.add(P2);
                System.out.println(allPeople.indexOf(P2));
                    break;
            case "-u" :
                if (args[3].equals("ж"))
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], new SimpleDateFormat("dd/MM/yyyy").parse(args[4])));
                else allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], new SimpleDateFormat("dd/MM/yyyy").parse(args[4])));
                break;
            case "-d" :
                Person P = Person.createFemale(null, null);
                P.setSex(null);
                allPeople.set(Integer.parseInt(args[1]), P );
                break;
            case "-i" :
                Person P1 = allPeople.get(Integer.parseInt(args[1]));
                System.out.print(P1.getName() + " ");
                if (P1.getSex() == Sex.FEMALE) System.out.print("ж");
                else System.out.print("м");
                System.out.println(" " + new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(P1.getBirthDay()));
                break;
            default:
                System.out.println("Неверные параметры!");
                break;
            }
        } catch (ParseException e) {}

    }
}
