package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

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
        course = new Course("TDD");
    }

    //******************************************** Test Methods *************************************************

    /**
     * TODO Assertion Msg. #
     * TODO Refactor.
     */
    @Test
    public void addCourseToSemesterTest() {
        //Fixture setup..
        //Expected
        ArrayList<Course> expectedCourses = new ArrayList<Course>();
        expectedCourses.add(course);
        //Actual
        semester.addCourse(course);

        //Verification..
        assertEquals("Failed to add Course to Semester.", expectedCourses, semester.getCourses());
    }

    @Test
    public void hasCourseTest() {
        //Fixture setup..
        semester.addCourse(course);

        //Verification..
        assertTrue("Failed to check if the Semester contains the course.", semester.hasCourse(course));
    }

    @Test
    public void getCourseTest() {
        //Fixture setup..
        semester.addCourse(course);

        //Verification..
        assertEquals("Failed to get course from semester.", course, semester.getCourse("TDD"));
    }
}
