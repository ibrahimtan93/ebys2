package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO View course mark
 * -TODO View midterm mark #
 * -TODO View final mark #
 * -TODO Normalize viewing course marks #
 * -TODO View course's term mark #
 * TODO Transfer Course related tests to CourseTest #
 * TODO View a term's grade point avarage #
 * TODO View cumulative grade point avarage #
 * TODO Student Enrollment #
 * --TODO Only enroll to current semester courses, semester is a container class
 *
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    private Student student;
    private Course course;

    @Before
    public void setup() throws CourseActivityException {
        student = new Student();
        course = new Course("TDD");
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));
    }

    @Test
    public void enrollmentTest(){
        student.enroll(course);

        assertTrue(student.isEnrolled(course));
    }
}
