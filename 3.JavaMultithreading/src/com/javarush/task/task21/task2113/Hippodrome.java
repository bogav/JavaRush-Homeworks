package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 6.06.2017.
 */
public class Hippodrome {
    private static List<Horse> horses = new ArrayList<Horse>();
    public static Hippodrome game;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void move (){
        for (int i = 0; i < 3; i++) {
            horses.get(i).move();
        }
    }

    public void print (){
        for (int i = 0; i < horses.size(); i++)
            horses.get(i).print();
        for (int i = 0; i < 10; i++)
            System.out.println("");
    }

    public void run () throws Exception{
        for (int i = 0; i < 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }

    public Horse getWinner() {
        Horse result = new Horse("", 0, 0);
        for (int i = 0; i < horses.size(); i++)
            if (result.getDistance()<horses.get(i).getDistance()) result = horses.get(i);
        return result;
    }

    public void printWinner() {
        System.out.println("Winner is " + this.getWinner().getName() + "!");
    }

    public static void main(String[] args) throws Exception{
        game = new Hippodrome(horses);
        Horse horse1 = new Horse("Sleven",3,0);
        Horse horse2 = new Horse("Lucky",3,0);
        Horse horse3 = new Horse("Gomer",3,0);
        horses.add(horse1);
        horses.add(horse2);
        horses.add(horse3);
        game.run();
        game.printWinner();
    }
}
