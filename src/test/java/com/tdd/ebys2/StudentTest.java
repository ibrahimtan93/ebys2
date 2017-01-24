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
        student = new Student(1253, "Murat Can");
        course = mock(Course.class);
    }

    //**************************************** Test Methods *************************************
    @Test
    public void addEnrollmentTest(){
        //Fixture Setup
        Enrollment enrol = new Enrollment(course, student);

        //Exercise
        student.addEnrollment(enrol);

        //Verification..
        assertEquals("Failed to add Enrollment to the Student.", 1, student.getEnrollments().size());
    }

    @Test
    public void isEnrolledTest() throws Exception {
        //Fixture Setup
        Enrollment enrol = new Enrollment(course, student);
        student.addEnrollment(enrol);

        //Verify..
        assertTrue("Failed to check if the student is enrolled to a course.", student.isEnrolled(course));
    }
}
