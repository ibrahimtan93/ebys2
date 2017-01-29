package com.tdd.ebys2.Teacher;

import com.tdd.ebys2.Course.Course;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Teacher {
    private final String name;
    private ArrayList<Course> courses = new ArrayList<Course>();

    public Teacher(String name) {
        this.name = name;
    }

    public ArrayList<Course> getCourses() {
        return this.courses;
    }
}
