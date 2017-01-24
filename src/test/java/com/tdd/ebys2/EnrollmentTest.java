package com.tdd.ebys2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


//TODO Enrollment'lara not girişi yapılacak
//TODO Birden fazla öğrencinin enroll olduğu derslerde, her öğrenci için ayrı not girilecek. (Side Effect olacak)
//TODO Course'dan (CourseActivity'den) notlar çıkarılıp enrollment a implement edilecek
//TODO Öğrenci ulaştıüı için notlara Proxy pattern uygulanacak
/**
 * Created by prometheus on 1/24/17.
 */
public class EnrollmentTest {

    private Enrollment enrollment;
    Student student ;
    Course course ;
    private CourseActivity activityMidterm;
    private CourseActivity activityFinal;

    @Before
    public void setup(){
        //Fixture setup..
        //course = new Course("TDD");

        student = mock(Student.class);
        course = mock(Course.class);

        enrollment = new Enrollment(course, student);

        activityMidterm = CourseActivity.MIDTERMEXAM(40);
        activityFinal= CourseActivity.FINALEXAM(60);
    }

    @Test
    public void CreateEnrollmentTest(){
        student = mock(Student.class);
        course = mock(Course.class);

        Enrollment enrollment = new Enrollment(course, student);

        assertTrue("Failed to create enrollment",enrollment instanceof Enrollment);
    }





    //**************************************** Verification *************************************
    @Test
    public void addActivityTest() throws CourseActivityException {
        //Fixture setup..
        enrollment.addActivity(activityMidterm);

        //Verification..
        assertEquals("Failed to add CourseActivity to Course.", activityMidterm, enrollment.getActivity("MidtermExam"));
    }

    @Test
    public void addActivityTest_sameActivityException() {
        //Verification..
        try{
            enrollment.addActivity(activityMidterm);
            enrollment.addActivity(activityMidterm);
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
            enrollment.addActivity(activityFinal);
            enrollment.addActivity(activityFinal);
            fail("Failed to throw CourseActivityException when trying to add activities whose percentage sum excels 100.");
        }
        catch (Exception e){
            assertTrue(e instanceof CourseActivityException);
        }
    }

    @Test
    public void viewCourseActivityMarkTest() throws CourseActivityException, MarkException {
        //Fixture setup..
        activityMidterm.setMark(50);
        enrollment.addActivity(activityMidterm);

        //Verification..
        assertEquals("Failed to view CourseActivity mark.",50,
                enrollment.getActivity("MidtermExam").getMark(), 0.02);
    }

    @Test
    public void calculateTermMarkTest() throws CourseActivityException, MarkException {
        //Fixture setup..
        activityMidterm.setMark(80);
        activityFinal.setMark(100);
        enrollment.addActivity(activityMidterm);
        enrollment.addActivity(activityFinal);

        //Verification..
        assertEquals("Failed to calculate Course's term mark.", 92,
                enrollment.calculateTermMark(), 0.02);
    }

    @Test
    public void calculateTermGradeTest() throws CourseActivityException, MarkException {
        //Fixture setup..
        activityMidterm.setMark(80);
        activityFinal.setMark(100);
        enrollment.addActivity(activityMidterm);
        enrollment.addActivity(activityFinal);

        //Verification..
        assertEquals("Failed to calculate correct Grade letter for the Term Mark.",
                "AA", enrollment.calculateTermGrade());
    }
}
