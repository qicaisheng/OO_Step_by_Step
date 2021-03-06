package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Klass implements KlassSubject {
    private final int klassNumber;
    private final List<Student> students = new ArrayList<>();
    private Teacher teacher;
    private final List<KlassObserver> klassObservers = new ArrayList<>();

    public Klass(int klassNumber) {
        this.klassNumber = klassNumber;
    }

    public int getKlassNumber() {
        return klassNumber;
    }

    public void appendMember(Student student) {
        students.add(student);
        this.register(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void assign(Teacher teacher) {
        this.teacher = teacher;
        register(teacher);
    }

    @Override
    public void register(KlassObserver klassObserver) {
        this.klassObservers.add(klassObserver);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public void notify(String message) {
        klassObservers.forEach(klassObserver -> klassObserver.receive(message));
    }

}
