package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * TODO Every semester some number of courses are opened
 * TODO A teacher must be assigned to each course.
 * -TODO Every teacher of courses specifies course activities and their percentages
 * --TODO Only course's teacher can change her/his courses specs
 * TODO Students enrolls to these courses
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {


    @Test
    public void assignTeacherToCourse(){
        Course tdd = new Course("Test Driven Development");
        Teacher teacher = new Teacher("Oguz Dikenelli");
        tdd.assignTeacher(teacher);
        Assert.assertEquals("Oguz Dikenelli",tdd.getTeacherName());
        Assert.assertTrue(teacher.hasCourse("Test Driven Development"));


    }



}
