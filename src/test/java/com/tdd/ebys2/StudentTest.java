package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    //**************************************** Test Methods *************************************
    @Test
    public void enrollmentTest(){
        //Fixture setup..
        Student student = new Student();
        Course course = mock(Course.class);

        //Exercise..
        student.enroll(course);

        //Verification..
        assertEquals("Failed to enroll Student to a Course.", 1, student.getCourses().size());
    }
}
