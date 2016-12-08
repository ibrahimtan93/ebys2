package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Transfer all CourseActivity related tests to here.
 * TODO 5 types of CourseActivity: MidtermExam, FinalExam, HomeWork, Presentation, Project !!Smelllssss
 *
 * Created by darthvader on 08.12.2016.
 */
public class CourseActivityTest {
    private Course course;

    @Before
    public void setup(){
        course = new Course("TDD");
    }

    @Test
    public void courseActivityFactoryTest() throws CourseActivityException {
        CourseActivity activity = CourseActivity.midtermExam(40);
        CourseActivity activity2 = CourseActivity.finalExam(60);

        assertEquals("MidtermExam", activity.getType());
        assertEquals("FinalExam", activity2.getType());
    }
}
