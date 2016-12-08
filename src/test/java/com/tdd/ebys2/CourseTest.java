package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

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
    public void addActivityTest() throws CourseActivityException {
        CourseActivity activity = CourseActivity.midtermExam(40);
        CourseActivity activity2 = CourseActivity.finalExam(60);
        course.addActivity(activity);
        course.addActivity(activity2);

        assertTrue(course.containsActivityType(activity));
        assertTrue(course.containsActivityType(activity2));
    }

    @Test(expected = CourseActivityException.class)
    public void addSameActivityTest() throws CourseActivityException {
        CourseActivity activity = CourseActivity.midtermExam(40);
        CourseActivity activity2 = CourseActivity.midtermExam(30);
        course.addActivity(activity);
        course.addActivity(activity2);
    }

    @Test(expected = CourseActivityException.class)
    public void addActivityPercentageTest() throws CourseActivityException {
        CourseActivity activity = CourseActivity.midtermExam(50);
        CourseActivity activity2 = CourseActivity.finalExam(60);
        course.addActivity(activity);
        course.addActivity(activity2);
    }

    /*
    //Refactoring needed
    @Test
    public void viewCourseMarkTest(){
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(50, course.getMidtermMark());
        assertEquals(100, course.getFinalMark());
    }

    //Refactoring needed
    @Test
    public void calculateTermMarkTest() throws CourseActivityException {
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(75, course.calculateTermMark(), 0.2);
    }*/

}
