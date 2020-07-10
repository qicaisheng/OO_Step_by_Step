package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements KlassObserver {
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
        super.setName(name);
        klass.notifyChanged(this);
    }

    @Override
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
        previousKlass.notifyChanged(this);
        this.klass.notifyChanged(this);

    }

}
