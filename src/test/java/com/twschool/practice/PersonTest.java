package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void should_output_name_and_age_when_introduce() {
        Person person = new Person("Tom", 21);
        
        String message = person.introduce();

        Assert.assertEquals("My name is Tom. I am 21 years old.", message);
    }
}
