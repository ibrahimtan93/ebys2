package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

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
 * TODO Transfer all course related tests to CourseTest #
 * --TODO Change coursesListAdd function to take Course object #
 *
 * Created by darthvader on 07.12.2016.
 */
public class TeacherTest {
    /**
     * TODO Assetion Msg Smell #
     */
    @Test
    public void addCourseTest() {
        //Fixture setup..
        Teacher teacher = new Teacher("İbrahim Tan");
        Course course = mock(Course.class);
        teacher.addCourse(course);

        //Verification..
        assertEquals("Failed to add course to the teacher.", 1, teacher.getCourses().size());
    }
}
