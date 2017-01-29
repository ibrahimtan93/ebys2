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
}
