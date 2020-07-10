package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private Klass klass;
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
        klass.notifyNameChanged(previousName, this);
    }

    public void receive(String message) {
        notifyMessages.add(message);
    }

    public String introduceNow() {
        return super.introduce() + String.format(" I am a Student of Class %d now.", klass.getKlassNumber());
    }

    public List<String> getNotifyMessages() {
        return notifyMessages;
    }

    public void setKlass(Klass klass) {
        Klass previousKlass = this.klass;
        this.klass = klass;
        notifyKlassChanged(previousKlass);

    }

    public void notifyKlassChanged(Klass previousKlass) {
        notifyKlassLeaved(previousKlass);
        notifyKlassJoined();
    }

    private void notifyKlassLeaved(Klass previousKlass) {
        previousKlass.getTeacher().receive(introduceNow());
        previousKlass.getStudents().stream()
                .filter(student -> !student.getName().equals(getName()))
                .forEach(otherStudent -> otherStudent.receive(introduceNow()));
    }

    private void notifyKlassJoined() {
        klass.getTeacher().receive(introduceNow());
        klass.getStudents().stream()
                .filter(student -> !student.getName().equals(getName()))
                .forEach(otherStudent -> otherStudent.receive(introduceNow()));
    }
}
