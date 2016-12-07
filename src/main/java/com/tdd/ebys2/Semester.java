package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by prometheus on 12/8/16.
 */
public class Semester {
    ArrayList<Course> semesterCourses = new ArrayList<Course>();


    public void addSemesterCourses(Course course) {
        semesterCourses.add(course);
    }

    public boolean hasCourse(Course course) {
        if (semesterCourses.contains(course))
            return true;
        else
            return false;
    }
}
