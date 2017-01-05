package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Transfer all CourseActivity related tests to here. #
 * TODO 5 types of CourseActivity: MidtermExam, FinalExam, HomeWork, Presentation, Project !!Smelllssss #
 *
 *
 * Created by darthvader on 08.12.2016.
 */
public class CourseActivityTest {

    /**
     * TODO Assertion Msg Smell #
     */
    @Test
    public void courseActivityFactoryTest(){
        CourseActivity activity = CourseActivity.midtermExam(40);
        CourseActivity activity2 = CourseActivity.finalExam(60);

        assertEquals("Failed when creating \"MidtermExam\" activity.", "MidtermExam", activity.getType());
        assertEquals("Failed when creating \"FinalExam\" activity.", "FinalExam", activity2.getType());
    }

    @Test
    public void courseActivityMarkTest(){
        CourseActivity activity = CourseActivity.midtermExam(40);
        activity.setMark(60);

        assertEquals("Failed to set mark of the activity.", 60, activity.getMark(), 0.02);
    }
}
