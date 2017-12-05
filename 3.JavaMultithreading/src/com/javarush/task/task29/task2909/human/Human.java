package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Human implements Alive{
    private static int nextId = 0;
    private int id;
    protected int age;
    protected String name;

    protected Size size;

    private List<Human> children = new ArrayList<>();

    public class Size {
        public int height;
        public int weight;
    }

    public String getPosition() { return "Человек"; }

    public List<Human> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public void addChild(Human child) {
        children.add(child);
    }

    public void removeChild(Human child) {
        children.remove(child);
    }

    private BloodGroup bloodGroup;

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    /*
        public void tsetBloodGroup(int code) {
            switch (code){
                case 1: bloodGroup = BloodGroup.first();break;
                case 2: bloodGroup = BloodGroup.second();break;
                case 3: bloodGroup = BloodGroup.third();break;
                case 4: bloodGroup = BloodGroup.fourth();break;
            }
        }

        public int getBloodGroup() {
            return bloodGroup.getCode();
        }
    */
    public void live() {

    }

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
        this.id = nextId;
        nextId++;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getId() {
        return id;
    }

    public void printSize() {
        System.out.println("Рост: " + size.height + " Вес: " + size.weight);
    }

    public void printData() {
        System.out.println(this.getPosition() + ": " + name);
    }

}