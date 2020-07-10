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

}
