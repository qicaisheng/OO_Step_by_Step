package com.twschool.practice;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private final int klassNumber;
    private final List<Student> students = new ArrayList<>();
    private Teacher teacher;

    public Klass(int klassNumber) {
        this.klassNumber = klassNumber;
    }

    public int getKlassNumber() {
        return klassNumber;
    }

    public void appendMember(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void assign(Teacher teacher) {
        this.teacher = teacher;   
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void notifyNameChanged(String previousName, Student student) {
        String message = student.introduceNow();
        getTeacher().receive(message);
        getStudents().stream()
                .filter(anyStudent -> !anyStudent.getName().equals(previousName))
                .forEach(otherStudent -> otherStudent.receive(message));
    }
}
