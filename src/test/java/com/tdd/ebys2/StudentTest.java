package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * TODO View course mark
 * -TODO View midterm mark #
 * -TODO View final mark #
 * -TODO Normalize viewing course marks #
 * -TODO View course's term mark #
 * TODO Transfer Course related tests to CourseTest #
 * TODO View a term's grade point average #
 * TODO View cumulative grade point average #
 * TODO Student Enrollment #
 * --TODO Only enroll to current semester courses, semester is a container class
 * --TODO Enrollment refactor for semester
 * --TODO if semester doesnt have course throw exception
 * --TODO student can only enroll to the available courses
 * ---TODO Course term is equal or below students term
 * TODO Calculate term grade average
 * TODO Call course from semester with index or object
 * --TODO Needs equals method
 *
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    //**************************************** Test Methods *************************************
    /**
     * TODO Two different condition. #
     * TODO Use exception pattern for readability. #
     * TODO Assertion Msg smell.  #
     * TODO Refactor so tests the actual behavior. #
     */
    @Test
    public void enrollmentTest(){
        //Fixture setup..
        Student student = new Student();
        Course course = mock(Course.class);
        student.enroll(course);

        //Verification..
        assertEquals("Failed to enroll Student to a Course.", 1, student.getCourses().size());
    }
}
