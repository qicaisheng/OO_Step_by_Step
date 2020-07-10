package com.twschool.practice;

public class Teacher extends Person {
    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher.";
    }
}
