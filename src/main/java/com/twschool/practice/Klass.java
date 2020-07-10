package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Klass {
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
        this.klassObservers.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void assign(Teacher teacher) {
        this.teacher = teacher;   
        this.klassObservers.add(teacher);
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void notifyNameChanged(Student student) {
        String message = student.introduceNow();
        klassObservers.forEach(klassObserver -> klassObserver.receive(message));
    }

    void notifyKlassJoined(Student student) {
        String message = student.introduceNow();
        klassObservers.forEach(klassObserver -> klassObserver.receive(message));
    }

    void notifyKlassLeaved(Student student) {
        String message = student.introduceNow();
        klassObservers.forEach(klassObserver -> klassObserver.receive(message));
    }
}
