package com.tdd.ebys2.Course;

import com.tdd.ebys2.Course.ActivityTypes;
import com.tdd.ebys2.Course.CourseActivity;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by darthvader on 08.12.2016.
 */
public class CourseActivityTest {

    @Test
    public void createCourseActivityTest(){
        //Fixture setup..
        CourseActivity activity = new CourseActivity(ActivityTypes.FINALEXAM, 40);

        //Verify..
        assertTrue("Failed to create CourseActivity object.", activity instanceof CourseActivity);
    }

    @Test
    public void createCourseActivityTest_sameActivity() {
        //Exercise..
        CourseActivity activity1 = new CourseActivity(ActivityTypes.FINALEXAM, 40);
        CourseActivity activity2 = new CourseActivity(ActivityTypes.FINALEXAM, 40);

        //Verify
        assertCourseActivitiesEqual("CourseActivy objects are not equal.", activity1, activity2);
    }

    static void assertCourseActivitiesEqual(String msg, CourseActivity expected, CourseActivity actual){
        assertEquals(msg + "Type.", expected.getType(), actual.getType());
        assertEquals(msg + "Percentage.", expected.getPercentage(), actual.getPercentage());
    }
}
