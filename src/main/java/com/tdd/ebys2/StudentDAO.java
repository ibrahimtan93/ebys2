package com.tdd.ebys2;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by darthvader on 24.01.2017.
 */
public class StudentDAO implements IStudentDAO{
    private DBConnection con;

    public StudentDAO(DBConnection con){
        this.con = con;
    }

    public ArrayList<Student> getAllStudents() {
        return con.executeQuery("getallstudents");
    }

    public Student getStudent(int studentNumber) {
        return (Student) con.executeQuery("getStudent").get(0);
    }

    public void addStudent(Student student) {

    }

    public void updateStudent(Student studentOld, Student studentNew) {

    }

    public void deleteStudent(Student student) {

    }
}
