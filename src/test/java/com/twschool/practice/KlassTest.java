package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

public class KlassTest {

    @Test
    public void should_contain_klass_number_when_construct_klass() {
        Klass klass = new Klass(2);
        
        int klassNumber = klass.getKlassNumber();

        Assert.assertEquals(2, klassNumber);
    }
}
