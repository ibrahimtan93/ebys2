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
 * TODO Call course from semester with index or object
 * --TODO Needs equals method
 *
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {

    //**************************************** Fixture Methods *************************************
    private Student student;
    private Course course;
    private Semester semester;

    /**
     * TODO Use mock objects for setup.
     *
     * @throws CourseActivityException
     */
    @Before
    public void setup() throws CourseActivityException {
        //Fixture setup..
        semester = new Semester();
        student = new Student();
        course = new Course("TDD");
        course.addActivity(CourseActivity.midtermExam(40));
        course.addActivity(CourseActivity.finalExam(60));
        semester.addCourse(course);
    }


    //**************************************** Test Methods *************************************
    /**
     * TODO Two different condition. #
     * TODO Use exception pattern for readability. #
     * TODO Assertion Msg smell.  #
     */
    @Test
    public void enrollmentTest(){
        //Fixture setup..
        student.enroll(semester.getCourse("TDD"));

        //Verification..
        try{
            student.enroll(semester.getCourse("Algorithms"));
            fail("Failed to throw exception when trying to enroll to a nonexistent course.");
        }
        catch (Exception e){
            assertTrue(e instanceof NullPointerException);
        }
    }
}
