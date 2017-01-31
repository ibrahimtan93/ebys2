package com.tdd.ebys2.Course;

import com.tdd.ebys2.Enrollment.Enrollment;
import com.tdd.ebys2.Teacher;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by darthvader on 07.12.2016.
 */
public class Course {
    private final int ID;
    private final String name;
    private Teacher teacher;
    private ArrayList<CourseActivity> activities;
    private ArrayList<Enrollment> enrollments;

    public Course(int id, String name) {
        this.ID = id;
        this.name = name;
        this.activities = new ArrayList<CourseActivity>();
        this.enrollments = new ArrayList<Enrollment>();
    }

    public int getID() { return ID; }

    public String getCourseName() {
        return this.name;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }


    public ArrayList<CourseActivity> getActivities() {
        return activities;
    }

    public CourseActivity getActivity(ActivityTypes activityType) {
        for (CourseActivity ca : activities){
            if(ca.getType() == activityType) return ca;
        }
        return null;
    }

    public void addActivity(CourseActivity activity) throws CourseException {
        if(this.getActivity(activity.getType()) !=  null)
            throw new CourseException("Same type of CourseActivity Object.");
        if(this.activityPercentageSum() + activity.getPercentage() > 100)
            throw new CourseException("CourseActivity percentage sum is more than 100.");
        this.activities.add(activity);
    }

    private int activityPercentageSum() {
        int sum = 0;
        for(CourseActivity ca : activities) sum += ca.getPercentage();
        return sum;
    }


    public ArrayList<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void addEnrollment(Enrollment enrollment) {
        this.enrollments.add(enrollment);
    }


}
