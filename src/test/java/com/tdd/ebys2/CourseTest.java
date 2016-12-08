package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * TODO Get all tests related to Courses to this test class
 *
 * Created by darthvader on 08.12.2016.
 */
public class CourseTest {
    private Course course;

    @Before
    public void setup(){
        course = new Course("TDD");
    }

    @Test
    public void viewCourseMarkTest(){
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(50, course.getMidtermMark());
        assertEquals(100, course.getFinalMark());
    }

    @Test
    public void calculateTermMarkTest() throws CourseActivityException {
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(75, course.calculateTermMark(), 0.2);
    }
}
