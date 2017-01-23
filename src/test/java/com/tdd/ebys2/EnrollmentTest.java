package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
/**
 * Created by prometheus on 1/24/17.
 */
public class EnrollmentTest {
    @Test
    public void CreateEnrollmentTest(){
        Student student = mock(Student.class);
        Course course = mock(Course.class);

        Enrollment enrollment = new Enrollment(course, student);

        assertTrue("Failed to create enrollment",enrollment instanceof Enrollment);
        verify(student).addEnrollment(enrollment);
    }




}
