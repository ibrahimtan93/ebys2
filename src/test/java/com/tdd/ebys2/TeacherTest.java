package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Specify course's term activities
 * - TODO Term activities = midtermExam, finalExam, homework, presentations, projects #
 * --- TODO More than one activity #
 * - TODO Specify the percentage of the activities #
 * ---TODO CourseActivity class that holds the activity name and percentage #
 * ---TODO Make sure that same activity cant exist
 * -----TODO Same Activity Object checking #
 * -----TODO Same Activity Name checking
 * -----TODO Create SameCourseActivityException class
 * ---TODO Make sure that all percentages sums up to 100
 *
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    Teacher teacher;
    Course course;
    @Before
    public void setup(){
        teacher = new Teacher();
        course = new Course();
    }

    @Test
    public void specifyCourseActivities() throws SameCourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 30);
        course.addActivity(activity);

        assertTrue(course.containsActivity(activity));
        assertFalse(course.containsActivity(new CourseActivity("finalExam", 60)));
    }

    @Test(expected = SameCourseActivityException.class)
    public void insertCheckSameActivityObject() throws SameCourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 30);

        course.addActivity(activity);
        course.addActivity(activity);
    }
}
