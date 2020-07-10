package com.twschool.practice;

public interface KlassSubject {
    void register(KlassObserver klassObserver);

    void notify(String message);
}
