package com.tdd.ebys2.Service;

import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.DAO.DataException;
import com.tdd.ebys2.DAO.InMemoryDatabase;
import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Student;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 29.01.2017.
 */
public class EnrollmentMgmtFacadeTest {
    private EnrollmentMgmtFacade facade;
    private InMemoryDatabase spyDatabase;

    @Before
    public void setUp() {
        facade = new EnrollmentMgmtFacade();
        spyDatabase = spy(new InMemoryDatabase());
        facade.setDao(spyDatabase);
    }

    @Test
    public void getCourseTest() throws DataException {
        //Fixture setup..
        int courseID = 101;
        Course courseExpected = mock(Course.class);
        when(courseExpected.getID()).thenReturn(courseID);
        facade.createCourse(courseExpected);

        //Exercise..
        Course courseActual = facade.getCourseByID(courseID);

        //Verify..
        verify(spyDatabase, times(1)).addCourse(courseExpected); //guard verify
        assertEquals("Failed to get course from EnrollmentMgmtFacade", courseExpected.getID(), courseActual.getID());
        verify(spyDatabase, times(1)).getCourseByID(courseID);
    }

    @Test
    public void createEnrollmentTest(){
        //Fixture setup..
        Student student = mock(Student.class);
        Course course = mock(Course.class);

        //Exercise..
        Enrollment enrollment = facade.createEnrollment(course, student);

        //Verify..
        verify(student, times(1)).addEnrollment(enrollment);
        verify(course, times(1)).addEnrollment(enrollment);
        verify(spyDatabase, times(1)).addEnrollment(enrollment);
    }
}
