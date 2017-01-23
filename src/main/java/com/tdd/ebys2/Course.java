package com.tdd.ebys2;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * TODO Make midtermMark private #
 * TODO Make finalMark private #
 * TODO calculateTermMark = (midtermMark + finalMark)/2 #
 * TODO Make activiy private #
 * TODO More than one activity --> List #
 * TODO Change activities list to hold CourseActivities #
 * TODO Implement CourseActivityException #
 * TODO Implement InvalidCourseActivityExceoption #
 * TODO Big Refactor
 * TODO A course has a term and a term is
 *
 * Created by darthvader on 07.12.2016.
 */
public class Course {
    private final String name;
    private Teacher teacher;
    private ArrayList<CourseActivity> activities = new ArrayList();
    private ArrayList<Student> enrolledStudents = new ArrayList<Student> ();
    private ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();

    public Course(String name) { this.name = name; }

    public String getCourseName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) { this.teacher = teacher; }

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

    public boolean containsActivityType(CourseActivity activity) {
        String type = activity.getType();
        for(CourseActivity ca : activities){
            if(ca.getType().equals(type)) return true;
        }
        return false;
    }

    public CourseActivity getActivity(String activityType) {
        for (CourseActivity ca : activities){
            if(ca.getType().equals(activityType)) return ca;
        }
        return null;
    }

    public float calculateTermMark() {
        float sum = 0;
        for(CourseActivity ca : activities){
            sum += (float)(ca.getMark() * ca.getPercentage())/100;
        }
        return sum;
    }


    public void enroll(Student student) {
        this.enrolledStudents.add(student);
    }

    public ArrayList<Student> getEnrolledStudents(){
        return this.enrolledStudents;
    }

    public Student getEnrolledStudent(int number) {
        for (Student s : enrolledStudents) {
            if(s.getNumber() == number) return s;
        }
        return null;
    }

    public void addEnrollment(Enrollment enrollment) {
        enrollments.add(enrollment);
    }
}
