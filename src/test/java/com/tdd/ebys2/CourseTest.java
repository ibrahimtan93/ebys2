package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Get all tests related to Courses to this test class #
 * TODO viewCourseMarkTest refactoring
 * TODO calculateTermGrade
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

    @Test
    public void assignTeacherToCourse(){
        Teacher teacher = new Teacher("Oguz Dikenelli");
        course.setTeacher(teacher);

        assertEquals("Oguz Dikenelli",course.getTeacher().getName());
    }

    @Test
    public void viewCourseActivityMarkTest() throws CourseActivityException {
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));

        course.getActivity("MidtermExam").setMark(50);
        course.getActivity("FinalExam").setMark(100);

        assertEquals(50, course.getActivity("MidtermExam").getMark(), 0.02);
        assertEquals(100, course.getActivity("FinalExam").getMark(), 0.02);
    }

    @Test
    public void calculateTermMarkTest() throws CourseActivityException {
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));

        course.getActivity("MidtermExam").setMark(50);
        course.getActivity("FinalExam").setMark(100);

        assertEquals(80, course.calculateTermMark(), 0.02);
    }

    @Test
    public void calculateTermGradeTest() throws CourseActivityException {
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));
        course.getActivity("MidtermExam").setMark(50);
        course.getActivity("FinalExam").setMark(100);

        assertEquals("BB", course.calculateTermGrade());
    }

}
