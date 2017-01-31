package com.tdd.ebys2.Service;

import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.DAO.DataException;
import com.tdd.ebys2.DAO.InMemoryDatabase;
import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Student;

import java.util.ArrayList;

/**
 * Created by darthvader on 29.01.2017.
 */
public class EnrollmentMgmtFacade {
    private InMemoryDatabase dao;

    public void setDao(InMemoryDatabase dao) {
        this.dao = dao;
    }

    public void createCourse(Course course) {
        try{
            this.dao.addCourse(course);
        }
        catch (DataException e){
            System.out.println(e.getMessage());
        }
    }

    public Course getCourseByID(int courseID) {
        try {
            Course course = this.dao.getCourseByID(courseID);
            return course;
        }
        catch (DataException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public Enrollment createEnrollment(Course course, Student student) {
        Enrollment enrollment = new Enrollment(course, student);
        course.addEnrollment(enrollment);
        student.addEnrollment(enrollment);
        this.dao.addEnrollment(enrollment);
        return enrollment;
    }
}
