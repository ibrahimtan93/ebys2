package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by prometheus on 12/8/16.
 */
public class Semester {
    private ArrayList<Course> courses = new ArrayList<Course>();

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean hasCourse(Course course) {
       return courses.contains(course);

    }

    /*public ArrayList<Course> semesterCourses = new ArrayList<Course>();

    public void addSemesterCourses(Course course) {
        semesterCourses.add(course);
    }

    public boolean hasCourse(Course course) {
        if (semesterCourses.contains(course))
            return true;
        else
            return false;
    }


    public Course getCourseByName(String courseName) {
        for (Course sc : semesterCourses ){
            if(courseName == sc.getCourseName())
                return sc;
        }
        return null;
    }*/
}
