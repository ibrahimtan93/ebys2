package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 24.01.2017.
 */
public class StudentDAOTest {
    private StudentDAO studentDAO;
    private DBConnection con;

    @Before
    public void setup() {
        con = mock(DBConnection.class);
        studentDAO = new StudentDAO(con);
    }

    @Test
    public void createStudentDAOTest() {
        //Verify
        assertTrue("Failed to create StudentDAO object", studentDAO instanceof StudentDAO);
    }

    @Test
    public void getAllStudentsTest() {
        //Setup
        ArrayList<Student> list = new ArrayList<Student>();
        list.add(mock(Student.class));
        list.add(mock(Student.class));
        when(con.executeQuery(anyString())).thenReturn(list);
        //Verify
        assertEquals("Failed to get all students from DB.", 2, studentDAO.getAllStudents().size());
    }

    @Test
    public void getStudentTest() {
        //Setup
        int studentNumber = 0512;
        ArrayList<Student> list = new ArrayList<Student>();
        Student student = mock(Student.class);
        list.add(student);
        when(student.getNumber()).thenReturn(studentNumber);
        when(con.executeQuery(anyString())).thenReturn(list);

        //Verify
        assertEquals("Failed to get student from DB.", studentNumber, studentDAO.getStudent(studentNumber).getNumber());
    }

    @Test
    public void addStudentTest() {
        //TODO

    }

    @Test
    public void updateStudentTest() {
        //TODO

    }

    @Test
    public void deleteStudentTest() {
        //TODO

    }
}
