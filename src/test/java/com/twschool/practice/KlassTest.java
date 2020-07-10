package com.twschool.practice;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class KlassTest {

    @Test
    public void should_contain_klass_number_when_construct_klass() {
        Klass klass = new Klass(2);
        
        int klassNumber = klass.getKlassNumber();

        Assert.assertEquals(2, klassNumber);
    }

    @Test
    public void should_get_all_students_in_klass_when_get_students_given_students_join_klass() {
        Klass klass = new Klass(2);
        klass.appendMember(new Student("Tom", 21, 2));
        klass.appendMember(new Student("Steven", 22, 2));

        List<Student> students = klass.getStudents();
        
        Assert.assertEquals(2, students.size());
        Assert.assertEquals("Tom", students.get(0).getName());
    }

    @Test
    public void should_get_teacher_in_klass_given_klass_assign_teacher() {
        Klass klass = new Klass(2);
        klass.assign(new Teacher("Katt", 30));

        Teacher teacher = klass.getTeacher();
        
        Assert.assertNotNull(teacher);
        Assert.assertEquals("Katt", teacher.getName());
        Assert.assertEquals(30, teacher.getAge());
    }
}
