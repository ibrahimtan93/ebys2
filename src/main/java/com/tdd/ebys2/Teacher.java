package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Teacher {
    private final String name;
    private ArrayList<String> courseList = new ArrayList<String>();

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void coursesListAdd(Course courseName) {
        courseList.add(courseName);
    }


    public boolean hasCourse(String courseName) {
        if(courseList.contains(courseName))
            return true;
        else
            return false;
    }

    public void addActivityToCourse(Course course, CourseActivity activity) throws CourseActivityException {
        if(this.getName()==course.getTeacherName())
            course.addActivity(activity);
        else throw new CourseActivityException("This teacher doesn't teach this course");

    }
}
