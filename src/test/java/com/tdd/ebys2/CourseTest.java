package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by darthvader on 08.12.2016.
 */
public class CourseTest {
    //TODO calculateTermGrade
    //TODO Limit CourseActivity percentage between 0 and 100.
    //TODO Create Grade or Mark object.
    //TODO Change CourseActivity abstract class to interface, and then create Activity classes.
    //TODO Needs Mark/grade class
    //**************************************** Fixture *************************************
    private Course course;

    @Before
    public void setup(){
        //Fixture setup..
        course = new Course("TDD");

    }

    //**************************************** Verification *************************************

    @Test
    public void assignTeacherToCourse(){
        //Fixture setup..
        Teacher teacher = mock(Teacher.class);
        course.setTeacher(teacher);

        //Verification..
        assertEquals("Failed to assign Teacher to Course.", teacher,course.getTeacher());
    }


    @Test
    public void enrollTest() {
        //Fixture setup..
        Student student = mock(Student.class);

        //Exercise..
        course.enroll(student);

        //Verify..
        assertEquals("Failed to add Enrollment to Course.", 1, course.getEnrolledStudents().size());
    }
}
