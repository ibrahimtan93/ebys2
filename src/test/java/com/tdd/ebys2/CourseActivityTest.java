package com.tdd.ebys2;

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
    public void courseActivityMarkTest() throws MarkException {
        CourseActivity activity = new CourseActivity(ActivityTypes.MIDTERMEXAM, 40);
        activity.setMark(60);

        assertEquals("Failed to set mark of the activity.", 60, activity.getMark(), 0.02);
    }
}
