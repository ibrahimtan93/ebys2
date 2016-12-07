package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * TODO Specify course's term activities #
 * - TODO Term activities = midtermExam, finalExam, homework, presentations, projects #
 * --- TODO More than one activity #
 * - TODO Specify the percentage of the activities #
 * ---TODO CourseActivity class that holds the activity name and percentage #
 * ---TODO Make sure that same activity cant exist #
 * -----TODO Same Activity Object checking #
 * -----TODO Same Activity Name checking #
 * -----TODO Create CourseActivityException class #
 * ---TODO Make sure that all percentages sums up to 100 #
 * ---TODO Make sure that if the percentage sum is not 100, do not allow calculation of the course term mark. #
 * -----TODO Create InvalidCourseActivityPercentage class #
 * ---TODO Normalize CourseActivityExceptions #
 *
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    Teacher teacher;
    Course course;
    @Before
    public void setup(){
        teacher = new Teacher("Name Of Teacher");
        course = new Course("Name of Course");
    }

    @Test
    public void specifyCourseActivities() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 100);
        course.addActivity(activity);

        assertTrue(course.containsActivity(activity));
        assertFalse(course.containsActivity(new CourseActivity("finalExam", 60)));
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckSameActivityObject() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("finalExam", 100);

        course.addActivity(activity);
        course.addActivity(activity);
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckSameActivityName() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 30);
        CourseActivity activity2 = new CourseActivity("midtermExam", 30);

        course.addActivity(activity);
        course.addActivity(activity2);
    }

    @Test(expected = CourseActivityException.class)
    public void insertCheckPercentageSumMoreThan100() throws CourseActivityException {
        CourseActivity activity = new CourseActivity("midtermExam", 50);
        CourseActivity activity2 = new CourseActivity("finalExam", 80);

        course.addActivity(activity);
        course.addActivity(activity2);
    }
}
