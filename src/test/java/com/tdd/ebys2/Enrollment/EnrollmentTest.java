package com.tdd.ebys2;

import com.tdd.ebys2.Course.ActivityTypes;
import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.Course.CourseActivity;
import com.tdd.ebys2.Course.CourseException;
import com.tdd.ebys2.Student.Student;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by prometheus on 1/24/17.
 */
public class EnrollmentTest {
    //**************************************** Setup *************************************
    private Student student;
    private Course course;
    private Enrollment enrollment;

    @Before
    public void setup() {
        student = mock(Student.class);
        course = mock(Course.class);
        enrollment = new Enrollment(course, student);
    }

    //**************************************** Verification *************************************
    @Test
    public void CreateEnrollmentTest(){
        //Verify
        assertTrue("Failed to create enrollment",enrollment instanceof Enrollment);
    }

    @Test
    public void enterCourseActivityMark() {
        //Setup
        when(course.getActivity(any(ActivityTypes.class)))
                .thenReturn(new CourseActivity(ActivityTypes.MIDTERMEXAM, 40));
        Mark mark = mock(Mark.class);

        //Exercise
        enrollment.setActivityMark(course.getActivity(ActivityTypes.MIDTERMEXAM), mark);

        //Verify
        assertEquals("Failed to set Activity Mark on Enrollment object.", mark,
                enrollment.getActivityMark(course.getActivity(ActivityTypes.MIDTERMEXAM)));
    }

    @Test
    public void calculateTermMarkTest() throws MarkException {
        //Setup..
        when(course.getActivity(ActivityTypes.MIDTERMEXAM))
                .thenReturn(new CourseActivity(ActivityTypes.MIDTERMEXAM, 40));
        when(course.getActivity(ActivityTypes.FINALEXAM))
                .thenReturn(new CourseActivity(ActivityTypes.FINALEXAM, 60));
        enrollment.setActivityMark(course.getActivity(ActivityTypes.MIDTERMEXAM), new Mark(100));
        enrollment.setActivityMark(course.getActivity(ActivityTypes.FINALEXAM), new Mark(100));

        //Verify..
        assertEquals("Failed to get Term Mark of the enrollment.", 100, enrollment.getTermMark().getMark(), .2);
    }

    @Test
    public void calculateTermGradeTest() throws CourseException, MarkException {
        //Setup..
        when(course.getActivity(ActivityTypes.MIDTERMEXAM))
                .thenReturn(new CourseActivity(ActivityTypes.MIDTERMEXAM, 40));
        when(course.getActivity(ActivityTypes.FINALEXAM))
                .thenReturn(new CourseActivity(ActivityTypes.FINALEXAM, 60));
        enrollment.setActivityMark(course.getActivity(ActivityTypes.MIDTERMEXAM), new Mark(100));
        enrollment.setActivityMark(course.getActivity(ActivityTypes.FINALEXAM), new Mark(100));

        //Verification..
        assertEquals("Failed to calculate correct Grade letter for the Term Mark.",
                "AA", enrollment.getTermMark().getGrade());
    }
}
