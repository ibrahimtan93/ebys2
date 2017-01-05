package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Teacher {
    private final String name;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public ArrayList<Course> getCourses() {
        return this.courses;
    }

    public Teacher(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addCourse(Course course) {
        courses.add(course);
    }

    public boolean hasCourse(Course course) {
        return courses.contains(course);
    }
}
