package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * TODO Every semester some number of courses are opened
 * TODO A teacher must be assigned to each course.
 * -TODO Every teacher of courses specifies course activities and their percentages
 * TODO Students enrolls to these courses
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {


    @Test
    public void assignTeacherToCourse(){
        Course tdd = new Course();
        tdd.assignTeacher("Oguz Dikenelli");
        Assert.assertEquals("Oguz Dikenelli",tdd.getTeacher());
    }
}
