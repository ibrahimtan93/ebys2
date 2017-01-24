package com.tdd.ebys2;

import java.util.List;

/**
 * Created by darthvader on 24.01.2017.
 */
public interface IStudentDAO {
    List<Student> getAllStudents();
    Student getStudent(int studentNumber);
    void addStudent(Student student);
    void updateStudent(Student studentOld, Student studentNew);
    void deleteStudent(Student student);
}
