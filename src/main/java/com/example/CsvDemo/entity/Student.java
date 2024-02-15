package com.example.CsvDemo.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "Student")
@SequenceGenerator(name = "student_seq", sequenceName = "student_sequence", allocationSize = 1)
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int Id;
    private String Name;
    private int Age;
    private String Marks;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getMarks() {
        return Marks;
    }

    public void setMarks(String marks) {
        Marks = marks;
    }

    public Student(int id, String name, int age, String marks) {
        Id = id;
        Name = name;
        Age = age;
        Marks = marks;
    }

    public Student() {
    }
}
