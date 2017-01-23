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
    private CourseActivity activityMidterm;
    private CourseActivity activityFinal;

    @Before
    public void setup(){
        //Fixture setup..
        course = new Course("TDD");
        activityMidterm = CourseActivity.MIDTERMEXAM(40);
        activityFinal= CourseActivity.FINALEXAM(60);
    }

    //**************************************** Verification *************************************
    @Test
    public void addActivityTest() throws CourseActivityException {
        //Fixture setup..
        course.addActivity(activityMidterm);

        //Verification..
        assertTrue("Failed to add CourseActivity to Course.", course.containsActivityType(activityMidterm));
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
    public void assignTeacherToCourse(){
        //Fixture setup..
        Teacher teacher = mock(Teacher.class);
        course.setTeacher(teacher);

        //Verification..
        assertEquals("Failed to assign Teacher to Course.", teacher,course.getTeacher());
    }

    @Test
    public void viewCourseActivityMarkTest() throws CourseActivityException, MarkException {
        //Fixture setup..
        activityMidterm.setMark(50);
        course.addActivity(activityMidterm);

        //Verification..
        assertEquals("Failed to view CourseActivity mark.",50,
                course.getActivity("MidtermExam").getMark(), 0.02);
    }

    @Test
    public void calculateTermMarkTest() throws CourseActivityException, MarkException {
        //Fixture setup..
        activityMidterm.setMark(80);
        activityFinal.setMark(100);
        course.addActivity(activityMidterm);
        course.addActivity(activityFinal);

        //Verification..
        assertEquals("Failed to calculate Course's term mark.", 92,
                course.calculateTermMark(), 0.02);
    }
/*
    @Test
    public void calculateTermGradeTest() throws CourseActivityException {
        //Fixture setup..
        activityMidterm.setMark(80);
        activityFinal.setMark(100);
        course.addActivity(activityMidterm);
        course.addActivity(activityFinal);

        //Verification..
        assertEquals("Failed to calculate correct Grade letter for the Term Mark.",
                "AA", course.calculateTermGrade());
    }
*/
}
