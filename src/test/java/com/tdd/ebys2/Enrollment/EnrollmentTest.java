package com.tdd.ebys2.Enrollment;

import com.tdd.ebys2.Course.ActivityTypes;
import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.Course.CourseActivity;
import com.tdd.ebys2.Student;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by prometheus on 1/24/17.
 */
public class EnrollmentTest {
    @Test
    public void createEnrollmentTest() {
        //Fixture setup..
        Course course = mock(Course.class);
        Student student = mock(Student.class);

        //Exercise..
        Enrollment enrollment = new Enrollment(course, student);

        //Verification..
        assertTrue("Failed to create Enrollment object.", enrollment instanceof Enrollment);
    }

    @Test
    public void enterCourseActivityMark() {
        //Setup
        Enrollment enrollment = new Enrollment(mock(Course.class), mock(Student.class));
        CourseActivity activity = mock(CourseActivity.class);
        when(activity.getType()).thenReturn(ActivityTypes.FINALEXAM);

        Mark mark = mock(Mark.class);

        //Exercise
        enrollment.setActivityMark(activity, mark);

        //Verify
        assertEquals("Failed to set Activity Mark on Enrollment object.", mark,
                enrollment.getActivityMark(activity));
    }

    @Test
    public void calculateTermMarkTest() throws MarkException {
        //Setup..
        Enrollment enrollment = new Enrollment(mock(Course.class), mock(Student.class));

        CourseActivity activity1 = mock(CourseActivity.class);
        when(activity1.getType()).thenReturn(ActivityTypes.MIDTERMEXAM);
        when(activity1.getPercentage()).thenReturn(40);

        CourseActivity activity2 = mock(CourseActivity.class);
        when(activity2.getType()).thenReturn(ActivityTypes.FINALEXAM);
        when(activity2.getPercentage()).thenReturn(60);

        Mark mark1 = mock(Mark.class);
        when(mark1.getMark()).thenReturn((float)50);

        Mark mark2 = mock(Mark.class);
        when(mark2.getMark()).thenReturn((float)100);

        //Exercise..
        enrollment.setActivityMark(activity1, mark1);
        enrollment.setActivityMark(activity2, mark2);

        //Verify..
        assertEquals("Failed to get Term Mark of the enrollment.", 80,
                enrollment.getTermMark().getMark(), .2);
    }
}
