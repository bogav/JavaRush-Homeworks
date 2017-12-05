package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String firstName;
        private String lastName;
        private boolean sex;
        private int age;
        private float weight;
        private int kasv;

        public Human(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public Human(String firstName, boolean sex, int age, float weight, int kasv) {

            this.firstName = firstName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.kasv = kasv;
        }

        public Human(String firstName, boolean sex, int age, float weight) {

            this.firstName = firstName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, boolean sex, int age) {

            this.firstName = firstName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, boolean sex) {

            this.firstName = firstName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName, boolean sex, int age, float weight, int kasv) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
            this.kasv = kasv;
        }

        public Human(String firstName, String lastName, boolean sex, int age, float weight) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
            this.weight = weight;
        }

        public Human(String firstName, String lastName, boolean sex, int age) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.age = age;
        }

        public Human(String firstName, String lastName, boolean sex) {

            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
        }

        public Human(String firstName, String lastName) {

            this.firstName = firstName;
            this.lastName = lastName;
        }
    }
}
