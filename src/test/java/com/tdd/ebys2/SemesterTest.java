package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;


import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * TODO add courses to semester #
 * TODO
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {
    //******************************************** Fixture **********************************************
    private Semester semester;
    private Course course;

    @Before
    public void setup() {
        semester = new Semester();
        course = mock(Course.class);
        when(course.getCourseName()).thenReturn("TDD");
        semester.addCourse(course);
    }

    //******************************************** Test Methods *************************************************

    /**
     * TODO Assertion Msg. #
     * TODO Refactor. #
     */
    @Test
    public void addCourseToSemesterTest() {
        //Verification..
        assertEquals("Failed to add Course to Semester.", 1, semester.getCourses().size());
    }

    @Test
    public void hasCourseTest() {
        //Verification..
        assertTrue("Failed to check if the Semester contains the course.", semester.hasCourse(course));
    }

    @Test
    public void getCourseTest() {
        //Verification..
        assertEquals("Failed to get course from semester.", course, semester.getCourse("TDD"));
    }
}
