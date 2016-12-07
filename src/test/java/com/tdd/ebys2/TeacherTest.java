package com.tdd.ebys2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Specify course's term activities
 * - TODO Term activities = midtermExam, finalExam, homework, presentations, projects
 * --- TODO More than one activity
 * - TODO Specify the percentage of the activities
 *
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    @Test
    public void specifyCourseActivities(){
        Teacher teacher = new Teacher();
        Course course = new Course();

        course.addActivity("midtermExam");
        course.addActivity("finalExam");

        assertTrue(course.containsActivity("midtermExam"));
    }
}
