package com.tdd.ebys2;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Specify course's term activities
 * - TODO Term activities = midtermExam, finalExam, homework, presentations, projects #
 * --- TODO More than one activity #
 * - TODO Specify the percentage of the activities #
 * ---TODO CourseActivity class that holds the activity name and percentage #
 *
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    @Test
    public void specifyCourseActivities(){
        Teacher teacher = new Teacher();
        Course course = new Course();
        CourseActivity activity = new CourseActivity("midtermExam", 30);
        course.addActivity(activity);

        assertTrue(course.containsActivity(activity));
        assertFalse(course.containsActivity(new CourseActivity("finalExam", 60)));
    }
}
