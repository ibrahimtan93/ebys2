package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


/**
 * Created by darthvader on 08.12.2016.
 */
public class CourseTest {
    //TODO Limit CourseActivity percentage between 0 and 100.
    //TODO Create Grade or Mark object.
    //**************************************** Fixture *************************************
    private Course course;
    private CourseActivity activityMidterm;
    private CourseActivity activityFinal;

    @Before
    public void setup(){
        //Fixture setup..
        course = new Course("TDD");
        activityMidterm = new CourseActivity(ActivityTypes.MIDTERMEXAM, 40);
        activityFinal= new CourseActivity(ActivityTypes.FINALEXAM, 60);
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
    public void addActivityTest() throws CourseActivityException {
        //Fixture setup..
        course.addActivity(activityMidterm);

        //Verification..
        assertEquals("Failed to add CourseActivity to Course.",
                activityMidterm, course.getActivity(ActivityTypes.MIDTERMEXAM));
    }

    @Test
    public void addActivityTest_sameActivityException() {
        //Verification..
        try{
            course.addActivity(activityMidterm);
            course.addActivity(activityMidterm);
            fail("Failed to throw exception when trying to add same CourseActivity object to Course more than once.");
        }
        catch (Exception e){
            assertTrue(e instanceof CourseActivityException);
        }
    }

    @Test
    public void addActivityTest_percentageException() {
        //Verification..
        try{
            course.addActivity(activityFinal);
            course.addActivity(activityFinal);
            fail("Failed to throw CourseActivityException when trying to add activities whose percentage sum excels 100.");
        }
        catch (Exception e){
            assertTrue(e instanceof CourseActivityException);
        }
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
