package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {
    Semester thisSemester;
    Course sample;

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
