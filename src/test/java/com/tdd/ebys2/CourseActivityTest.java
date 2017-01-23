package com.tdd.ebys2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by darthvader on 08.12.2016.
 */
public class CourseActivityTest {
    @Test
    public void courseActivityFactoryTest(){
        //Fixture setup..
        CourseActivity activity = CourseActivity.MIDTERMEXAM(40);
        CourseActivity activity2 = CourseActivity.FINALEXAM(60);
        CourseActivity activity3 = CourseActivity.HOMEWORK(60);
        CourseActivity activity4 = CourseActivity.PRESENTATION(60);
        CourseActivity activity5 = CourseActivity.PROJECT(60);

        //Verify..
        assertEquals("Failed when creating \"MidtermExam\" activity.", "MidtermExam", activity.getType());
        assertEquals("Failed when creating \"FinalExam\" activity.", "FinalExam", activity2.getType());
        assertEquals("Failed when creating \"Homework\" activity.", "Homework", activity3.getType());
        assertEquals("Failed when creating \"Presentation\" activity.", "Presentation", activity4.getType());
        assertEquals("Failed when creating \"Project\" activity.", "Project", activity5.getType());

    }

    @Test
    public void courseActivityMarkTest(){
        CourseActivity activity = CourseActivity.MIDTERMEXAM(40);
        activity.setMark(60);

        assertEquals("Failed to set mark of the activity.", 60, activity.getMark(), 0.02);
    }
}
