package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 * TODO Every semester some number of courses are opened #
 * TODO A teacher must be assigned to each course. #
 * -TODO Every teacher of courses specifies course activities and their percentages
 * --TODO Only course's teacher can change her/his courses specs#
 * TODO Students enrolls to these courses
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {
    Semester thisSemester;
    Course sample;

    @Test
    public void assignTeacherToCourse(){
        Course tdd = new Course("Test Driven Development");
        Teacher teacher = new Teacher("Oguz Dikenelli");
        tdd.setTeacher(teacher);
        assertEquals("Oguz Dikenelli",tdd.getTeacher().getName());
        assertTrue(teacher.hasCourse("Test Driven Development"));
    }

    @Before
    public void setup(){
        thisSemester = new Semester();
        sample = new Course("TDD");
        thisSemester.addSemesterCourses(sample);

    }

    @Test
    public void addCourseToSemester(){
        assertTrue(thisSemester.hasCourse(sample));
        Course sample2 = new Course("Algorithms");
        assertFalse(thisSemester.hasCourse(sample2));
    }

    /*@Test(expected = CourseActivityException.class)
    public void courseActivitySafety() throws CourseActivityException {
        Teacher teacher = new Teacher("Oguz Dikenelli");
        thisSemester.getCourseByName("TDD").setTeacher(teacher);
        Course course = thisSemester.getCourseByName("TDD");
        teacher.addActivityToCourse(course,new CourseActivity("Midterm",40));
        Course course2 = new Course("Algorithms");
        Teacher teacher2 = new Teacher("Deneme");
        course2.setTeacher(teacher2);
        teacher.addActivityToCourse(course2,new CourseActivity("Final",50));
    }*/



}
