package com.twschool.practice;

public class Student extends Person {
    private final Klass klass;
    private int klassNumber;

    public Student(String name, int age, int klassNumber) {
        super(name, age);
        this.klassNumber = klassNumber;
        this.klass = new Klass(klassNumber);
    }

    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am at Class %d.", klass.getKlassNumber());
    }
}
