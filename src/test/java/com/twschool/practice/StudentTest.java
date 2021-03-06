package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class StudentTest {

    @Test
    public void should_output_name_and_age_and_class_number_when_introduce() {
        Klass klass = new Klass(2);
        Person student = new Student("Tom", 21, klass);
        
        String message = student.introduce();

        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.", message);
    }

    @Test
    public void should_notify_klass_teacher_when_student_name_change() {
        Klass klass = new Klass(2);
        Teacher teacher = new Teacher("Matt", 30);
        Student student = new Student("Tom", 21, klass);
        klass.assign(teacher);
        klass.appendMember(student);

        student.setName("Tom1");

        List<String> messages = teacher.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom1. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

    @Test
    public void should_notify_klass_other_students_when_student_name_change() {
        Klass klass = new Klass(2);
        Teacher teacher = new Teacher("Matt", 30);
        Student tom = new Student("Tom", 21, klass);
        Student steven = new Student("Steven", 21, klass);
        klass.assign(teacher);
        klass.appendMember(tom);
        klass.appendMember(steven);

        tom.setName("Tom1");

        List<String> messages = steven.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom1. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

    @Test
    public void should_notify_previous_klass_teacher_when_student_change_klass() {
        Klass klassOne = new Klass(1);
        Teacher teacher = new Teacher("Matt", 30);
        Student student = new Student("Tom", 21, klassOne);
        klassOne.assign(teacher);
        klassOne.appendMember(student);

        Klass klassTwo = new Klass(2);
        klassTwo.assign(new Teacher("Toy", 30));
        student.setKlass(klassTwo);

        List<String> messages = teacher.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

    @Test
    public void should_notify_previous_klass_students_when_student_change_klass() {
        Klass klassOne = new Klass(1);
        Teacher teacher = new Teacher("Matt", 30);
        Student tom = new Student("Tom", 21, klassOne);
        Student steven = new Student("Steven", 21, klassOne);

        klassOne.assign(teacher);
        klassOne.appendMember(tom);
        klassOne.appendMember(steven);

        Klass klassTwo = new Klass(2);
        klassTwo.assign(new Teacher("Toy", 30));
        tom.setKlass(klassTwo);

        List<String> messages = steven.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

    @Test
    public void should_notify_current_klass_students_when_student_change_klass() {
        Klass klassOne = new Klass(1);
        Teacher teacher = new Teacher("Matt", 30);
        Student tom = new Student("Tom", 21, klassOne);

        klassOne.assign(teacher);
        klassOne.appendMember(tom);

        Klass klassTwo = new Klass(2);
        klassTwo.assign(new Teacher("Toy", 30));
        Student steven = new Student("Steven", 21, klassTwo);
        klassTwo.appendMember(steven);
        
        tom.setKlass(klassTwo);

        List<String> messages = steven.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

    @Test
    public void should_notify_current_klass_teacher_when_student_change_klass() {
        Klass klassOne = new Klass(1);
        Student tom = new Student("Tom", 21, klassOne);

        klassOne.appendMember(tom);
        klassOne.assign(new Teacher("Toy", 30));

        Klass klassTwo = new Klass(2);
        Teacher teacher = new Teacher("Matt", 30);
        klassTwo.assign(teacher);

        tom.setKlass(klassTwo);

        List<String> messages = teacher.getNotifyMessages();
        Assert.assertEquals(1, messages.size());
        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student of Class 2 now.", messages.get(0));
    }

}
