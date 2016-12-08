package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Student {
    private ArrayList<Course> courses = new ArrayList<Course>();

    public void enroll(Course course) {
        this.courses.add(course);
    }

    public boolean isEnrolled(Course course) {
        return this.courses.contains(course);
    }
}
