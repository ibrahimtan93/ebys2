package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    @Test
    public void addCourseTest() {
        //Fixture setup..
        Teacher teacher = new Teacher("İbrahim Tan");
        Course course = mock(Course.class);

        //Exercise..
        teacher.addCourse(course);

        //Verification..
        assertEquals("Failed to add course to the teacher.", 1, teacher.getCourses().size());
    }
}
