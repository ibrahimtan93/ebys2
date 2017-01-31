package com.tdd.ebys2.DAO;

import com.tdd.ebys2.Course.Course;

import java.util.List;

/**
 * Created by darthvader on 29.01.2017.
 */
public interface ICourseDAO {
    List<Course> getAllCourse();
    Course getCourseByID(int ID) throws DataException;
    boolean addCourse(Course course) throws DataException;
    boolean updateCourse(Course course);
    boolean deleteCourse(Course course);
}
