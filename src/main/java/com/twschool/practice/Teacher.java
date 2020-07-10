package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {
    private final List<String> notifyMessages = new ArrayList<>();

    public Teacher(String name, int age) {
        super(name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a Teacher.";
    }

    public List<String> getNotifyMessages() {
        return notifyMessages;
    }

    public void notify(String message) {
        notifyMessages.add(message);
    }
}
