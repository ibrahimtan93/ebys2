package com.tdd.ebys2;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Course {
    private final String name;
    private Teacher teacher;
    private ArrayList<CourseActivity> activities;
    private ArrayList<Enrollment> enrollments;

    public Course(String name) {
        this.name = name;
        this.activities = new ArrayList<CourseActivity>();
        this.enrollments = new ArrayList<Enrollment>();
    }

    public String getCourseName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void addActivity(CourseActivity activity) throws  CourseActivityException {
        if(this.containsActivityType(activity)) throw new CourseActivityException("Same type of CourseActivity Object");
        if(this.activityPercentageSum() + activity.getPercentage() > 100)
            throw new CourseActivityException("CourseActivity percentage sum is more than 100");
        this.activities.add(activity);
    }

    private int activityPercentageSum() {
        int sum = 0;
        for(CourseActivity ca : activities) sum += ca.getPercentage();
        return sum;
    }

    private boolean containsActivityType(CourseActivity activity) {
        ActivityTypes type = activity.getType();
        for(CourseActivity ca : activities){
            if(ca.getType() == type) return true;
        }
        return false;
    }

    public CourseActivity getActivity(ActivityTypes activityType) {
        for (CourseActivity ca : activities){
            if(ca.getType() == activityType) return ca;
        }
        return null;
    }

    public void enroll(Student student) {
        Enrollment enrollment = new Enrollment(this, student);
        enrollments.add(enrollment);
        student.addEnrollment(enrollment);
    }

    public ArrayList<Student> getEnrolledStudents(){
        ArrayList<Student> students = new ArrayList<Student>();
        for (Enrollment e: enrollments){
            students.add(e.getStudent());
        }

        return students;
    }

    public Student getEnrolledStudent(int number) {
        for (Enrollment e: enrollments){
            if(e.getStudent().getNumber() == number) return e.getStudent();
        }
        return null;
    }
}
