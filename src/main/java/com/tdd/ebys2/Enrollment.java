package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * Created by prometheus on 1/24/17.
 */
public class Enrollment {
    private final Course course;
    private final Student student;
    private ArrayList<CourseActivity> activities;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.activities = new ArrayList<CourseActivity>();

    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void addActivity(CourseActivity activity) throws CourseActivityException {
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

    public String calculateTermGrade() throws MarkException {
        return new Mark(this.calculateTermMark()).getGrade();
    }
}
