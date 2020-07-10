package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class StudentTest {

    @Test
    public void should_output_name_and_age_and_class_number_when_introduce() {
        Person student = new Student("Tom", 21, 2);
        
        String message = student.introduce();

        Assert.assertEquals("My name is Tom. I am 21 years old. I am a Student. I am at Class 2.", message);
    }
}
