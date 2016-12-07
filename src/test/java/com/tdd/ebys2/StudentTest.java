package com.tdd.ebys2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO View course mark
 * -TODO View midterm mark #
 * -TODO View final mark #
 * -TODO Normalize viewing course marks #
 * -TODO View course's term mark #
 * TODO View a term's grade point avarage
 * TODO View cumulative grade point avarage
 *
 *
 * Created by darthvader on 07.12.2016.
 */
public class StudentTest {
    @Test
    public void viewCourseMark(){
        Student student = new Student();
        Course course = new Course();
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(50, course.getMidtermMark());
        assertEquals(100, course.getFinalMark());
    }

    @Test
    public void viewCourseTermMark() throws CourseActivityException {
        Student student = new Student();
        Course course = new Course();
        course.setMidtermMark(50);
        course.setFinalMark(100);

        assertEquals(75, course.calculateTermMark(), 0.2);
    }
}
