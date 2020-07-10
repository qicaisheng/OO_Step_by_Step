package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private final Klass klass;
    private final List<String> notifyMessages = new ArrayList<>();

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
        String previousName = getName();
        super.setName(name);
        String message = introduceNow();
        klass.getTeacher().notify(message);
        klass.getStudents().stream()
                .filter(student -> !student.getName().equals(previousName))
                .forEach(otherStudent -> otherStudent.notify(message));
    }

    private void notify(String message) {
        notifyMessages.add(message);
    }

    public String introduceNow() {
        return super.introduce() + String.format(" I am a Student of Class %d now.", klass.getKlassNumber());
    }

    public List<String> getNotifyMessages() {
        return notifyMessages;
    }
}
