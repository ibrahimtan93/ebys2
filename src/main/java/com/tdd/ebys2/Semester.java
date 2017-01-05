package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by prometheus on 12/8/16.
 */
public class Semester {
    private ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getCourses(){ return this.courses; }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean hasCourse(Course course) {
       return courses.contains(course);
    }

    public Course getCourse(String courseName) {
        for (Course co : courses){
            if(co.getCourseName() == courseName)
                return co;
        }
        return null;
    }
}
