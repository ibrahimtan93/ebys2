package com.tdd.ebys2.DAO;

import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Student;

import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/**
 * Created by darthvader on 29.01.2017.
 */
public class InMemoryDatabase implements ICourseDAO, IStudentDAO, IEnrollmentDAO {
    private List courses = new Vector();

    public List<Student> getAllStudent() {
        return null;
    }

    public Student getStudentByID(int ID) {
        return null;
    }

    public boolean addStudent(Student student) {
        return false;
    }

    public boolean updateStudent(Student student) {
        return false;
    }

    public boolean deleteStudent(Student student) {
        return false;
    }

    public List<Course> getAllCourse() {
        return null;
    }

    public Course getCourseByID(int ID) throws DataException {
        Course result = null;
        Iterator i = courses.iterator();
        while(i.hasNext()){
            result = (Course) i.next();
            if(result.getID() == ID) return result;
        }
        throw new DataException("Course not found. ID: " + ID);
    }

    public boolean addCourse(Course course) throws DataException {
        if(this.courses.contains(course)) throw new DataException("Course already exists. ID: " + course.getID());
        this.courses.add(course);
        return true;
    }

    public boolean updateCourse(Course course) {
        return false;
    }

    public boolean deleteCourse(Course course) {
        return false;
    }

    public List<Enrollment> getAllEnrollment() {
        return null;
    }

    public Enrollment getEnrollmentByID(int ID) {
        return null;
    }

    public boolean addEnrollment(Enrollment enrollment) {
        return false;
    }

    public boolean updateEnrollment(Enrollment enrollment) {
        return false;
    }

    public boolean deleteEnrollment(Enrollment enrollment) {
        return false;
    }
}
