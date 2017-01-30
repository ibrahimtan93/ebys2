package com.tdd.ebys2;

import com.tdd.ebys2.Course.Course;
import com.tdd.ebys2.Enrollment.Enrollment;

import java.util.ArrayList;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Student {
    private int number;
    private String name;
    private ArrayList<Enrollment> enrollments;

    public Student(int number, String name) {
        this.number = number;
        this.name = name;
        this.enrollments = new ArrayList<Enrollment>();
    }

    public int getNumber() {
        return this.number;
    }

    public String getName() {
        return name;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    public ArrayList<Enrollment> getEnrollments() { return this.enrollments; }

    public boolean isEnrolled(Course course) {
        for (Enrollment e : enrollments ) {
            if(e.getCourse() == course) return true;
        }
        return false;
    }

}
