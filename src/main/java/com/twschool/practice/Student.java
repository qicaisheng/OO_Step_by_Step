package com.twschool.practice;

public class Student extends Person {
    private final Klass klass;
    
    public Student(String name, int age, Klass klass) {
        super(name, age);
        this.klass = klass;
    }

    @Override
    public String introduce() {
        return super.introduce() + String.format(" I am a Student. I am at Class %d.", klass.getKlassNumber());
    }
    
    @Override
    public void setName(String name) {
        super.setName(name);
        klass.getTeacher().notify(introduceNow());
    }
    
    public String introduceNow() {
        return super.introduce() + String.format(" I am a Student of Class %d now.", klass.getKlassNumber());
    }
}
