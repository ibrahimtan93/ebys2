package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    private Student student;
    private Course course;

    //**************************************** Setup *************************************
    @Before
    public void setup() {
        student = new Student(1253, "Murat Can", "Üste");
        course = mock(Course.class);
    }

    //**************************************** Test Methods *************************************
    /*@Test
    public void enrollmentTest(){
        //Exercise
        student.enroll(course);

        //Verification..
        assertEquals("Failed to enroll Student to a Course.", 1, student.getCourses().size());
    }
    */
    /*
    @Test
    public void isEnrolledTest() throws Exception {
        //Exercise..
        student.enroll(course);

        System.out.println(student.isEnrolled(course));
        //Verify..
        assertTrue("Failed to check if the student is enrolled to a course.", student.isEnrolled(course));
    }
    */
}
