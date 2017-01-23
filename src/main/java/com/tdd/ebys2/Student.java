package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Student {
    private ArrayList<Course> courses;
    private int number;
    private String name;
    private String surname;

    public Student(int number, String name, String surname) {
        this.number = number;
        this.name = name;
        this.surname = surname;
        this.courses = new ArrayList();
    }

    public ArrayList<Course> getCourses() { return this.courses; }

    public void enroll(Course course) throws NullPointerException{
        if (course == null) throw new NullPointerException("Course is not defined.");
        course.enroll(this);
        this.courses.add(course);
    }

    public boolean isEnrolled(Course course) {
        return this.courses.contains(course);
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
