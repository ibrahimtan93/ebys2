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
 * TODO View a term's grade point average #
 * TODO View cumulative grade point average #
 * TODO Student Enrollment #
 * --TODO Only enroll to current semester courses, semester is a container class
 * --TODO Enrollment refactor for semester
 * --TODO if semester doesnt have course throw exception
 * --TODO student can only enroll to the available courses
 * ---TODO Course term is equal or below students term
 * TODO Calculate term grade average
 *
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    private Student student;
    private Course course;
    private Semester semester;

    @Before
    public void setup() throws CourseActivityException {
        semester = new Semester();
        student = new Student();
        course = new Course("TDD");
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));
        semester.addCourse(course);
    }

    @Test(expected = NullPointerException.class)
    public void enrollmentTest(){
        student.enroll(semester.getCourse("TDD"));

        assertTrue(student.isEnrolled(course));

        student.enroll(semester.getCourse("Algorithms"));
    }
}
