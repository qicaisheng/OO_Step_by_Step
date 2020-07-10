package com.twschool.practice;

public class Student extends Person {
    private int klassNumber;

    public Student(String name, int age, int klassNumber) {
        super(name, age);
        this.klassNumber = klassNumber;
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am at Class %d.", klassNumber);
    }
}
