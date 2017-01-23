package com.tdd.ebys2;

/**
 * Created by prometheus on 1/24/17.
 */
public class Enrollment {
    private final Course course;
    private final Student student;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;

        this.student.addEnrollment(this);
    }

    public Student getStudent() {
        return student;
    }
}
