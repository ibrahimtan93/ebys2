package com.tdd.ebys2.Course;

import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Teacher;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by darthvader on 08.12.2016.
 */
public class CourseTest {
    private Course course;

    //*******************************************************************************************************//
    private Course createAnonymousCourse() {
        Course course = new Course(101, "TDD");
        return course;
    }
    //*******************************************************************************************************//

    @Before
    public void setUp(){
        course = createAnonymousCourse();
    }

    @Test
    public void setTeacherTest(){
        //Fixture setup..
        Teacher teacher = mock(Teacher.class);
        Course expectedCourse = new Course(100, "SE");
        expectedCourse.setTeacher(teacher);

        //Exercise..
        course.setTeacher(teacher);

        //Verification..
        assertEquals("Failed to assign Teacher to Course.", teacher,course.getTeacher());
    }

    @Test
    public void addActivityTest() throws CourseException {
        //Fixture setup..
        CourseActivity activity = mock(CourseActivity.class);

        //Exercise..
        course.addActivity(activity);

        //Verification..
        assertEquals("Failed to add CourseActivity to Course.", 1, course.getActivities().size());
        assertEquals("Failed to add CourseActivity to Course.", activity, course.getActivities().get(0));
    }

    @Test
    public void addActivityTest_sameActivityException() {
        //Fixture setup..
        CourseActivity activity = mock(CourseActivity.class);

        //Exercise..
        try {
            course.addActivity(activity);
            course.addActivity(activity);
            fail("Failed to throw CourseException when trying to add same CourseActivity to Course.");
        }
        //Verify..
        catch (Exception e) {
            assertTrue("Type of the thrown exception is not CourseException.", e instanceof CourseException);
        }
    }

    @Test
    public void addActivityTest_percentageException() {
        //Fixture setup..
        CourseActivity activity1 = mock(CourseActivity.class);
        CourseActivity activity2 = mock(CourseActivity.class);
        when(activity1.getPercentage()).thenReturn(100);
        when(activity2.getPercentage()).thenReturn(30);

        //Exercise..
        try{
            course.addActivity(activity1);
            course.addActivity(activity2);
            fail("Failed to throw CourseException when trying to add activities whose percentage sum excels 100.");
        }
        catch (Exception e){
            assertTrue("Type of the thrown exception is not CourseException.", e instanceof CourseException);
        }
    }

    @Test
    public void addEnrollmentTest() {
        //Fixture setup..
        Enrollment enrollment = mock(Enrollment.class);

        //Exercise..
        course.addEnrollment(enrollment);

        //Verify..
        assertEquals("Failed to add Enrollment to Course's list.", 1, course.getEnrollments().size());
        assertEquals("Failed to add Enrollment to Course's list.", enrollment, course.getEnrollments().get(0));
    }
}
