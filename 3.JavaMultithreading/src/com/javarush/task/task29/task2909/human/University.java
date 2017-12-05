package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student item: students)
            if (item.getAverageGrade() == averageGrade) return item;
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        Student student = students.get(0);
        for (Student item: students)
            if (item.getAverageGrade() > student.getAverageGrade())
                student = item;
        return student;
    }

    public Student getStudentWithMinAverageGrade() {
        Student student = students.get(0);
        for (Student item: students)
            if (item.getAverageGrade() < student.getAverageGrade())
                student = item;
        return student;
    }

    public void expel(Student student) {
        students.remove(student);
    }

}