package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO Transfer all CourseActivity related tests to here.
 * Created by darthvader on 08.12.2016.
 */
public class CourseActivityTest {
    private Course course;

    @Before
    public void setup(){
        course = new Course("TDD");
    }

    @Test
    public void specifyCourseActivities() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 100);
        course.addActivity(activity);

        assertTrue(course.containsActivity(activity));
        assertFalse(course.containsActivity(new CourseActivity("finalExam", 60)));
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckSameActivityObject() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("finalExam", 100);

        course.addActivity(activity);
        course.addActivity(activity);
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckSameActivityName() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 30);
        CourseActivity activity2 = new CourseActivity("midtermExam", 30);

        course.addActivity(activity);
        course.addActivity(activity2);
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckPercentageSumMoreThan100() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 50);
        CourseActivity activity2 = new CourseActivity("finalExam", 80);

        course.addActivity(activity);
        course.addActivity(activity2);
    }
}
