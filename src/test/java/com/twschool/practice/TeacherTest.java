package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class TeacherTest {

    @Test
    public void should_output_name_and_age_and_teacher_when_introduce() {
        Person teacher = new Teacher("Matt", 30);
        
        String message = teacher.introduce();

        Assert.assertEquals("My name is Matt. I am 30 years old. I am a Teacher.", message);
    }
}
