package com.tdd.ebys2.DAO;

import com.tdd.ebys2.Student;

import java.util.List;

/**
 * Created by darthvader on 29.01.2017.
 */
public interface IStudentDAO {
    List<Student> getAllStudent();
    Student getStudentByID(int ID);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
}
