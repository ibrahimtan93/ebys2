package com.tdd.ebys2;

import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Student;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

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
    public void getNameTest() {
        //Setup
        String expectedName = "Murat Can";

        //Verify
        assertEquals("Failed to get name of Student.", expectedName, student.getName());
    }

    @Test
    public void addEnrollmentTest(){
        //Fixture Setup
        Enrollment enrollment = mock(Enrollment.class);

        //Exercise
        student.addEnrollment(enrollment);

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
