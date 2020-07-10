package com.twschool.practice;

public interface KlassSubject {
    void register(KlassObserver klassObserver);

    void notifyChanged(Student student);

    void notify(String message);
}
