package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * TODO add courses to semester
 * TODO
 *
 * Created by prometheus on 12/7/16.
 */
public class SemesterTest {
    private Semester semester;
    private Course course;
    //private Student student;
    //private ArrayList<Course> courses;

    /*@BeforeClass
    public void setupCourses(){
        courses = new ArrayList<Course>();
        Course course;
        course = new Course("Software Engineering");
        course.setTerm(7);
        courses.add(course);

        course = new Course("Algorithm - 1");
        course.setTerm(1);
        courses.add(course);

        course = new Course("Algorithm - 2");
        course.setTerm(2);
        courses.add(course);

        course = new Course("Matematik - 1");
        course.setTerm(1);
        courses.add(course);

        course = new Course("Mantık Devreleri - 2");
        course.setTerm(3);
        courses.add(course);

        course = new Course("Database Management");
        course.setTerm(5);
        courses.add(course);

    }*/

    @Before
    public void setup() {
        semester = new Semester();
        course = new Course("TDD");
        //student = new Student();
    }

    @Test
    public void addCourseToSemesterTest(){
        semester.addCourse(course);
        assertTrue(semester.hasCourse(course));
    }

    /*@Test
    public void getAvailableCoursesTest(){
        Student student = new Student();
        student.setTerm(5);

        ArrayList<Course> courseList = semester.getAvailableCourses(student);
        ArrayList<Course> expectedList;
        assertArrayEquals(expectedList,courseList);
    }
    /*Semester thisSemester;
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
