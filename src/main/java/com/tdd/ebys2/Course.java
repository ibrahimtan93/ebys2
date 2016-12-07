package com.tdd.ebys2;

import java.util.ArrayList;

/**
 * TODO Make midtermMark private #
 * TODO Make finalMark private #
 * TODO calculateTermMark = (midtermMark + finalMark)/2 #
 * TODO Make activiy private #
 * TODO More than one activity --> List #
 * TODO Change activities list to hold CourseActivities #
 * TODO Implement CourseActivityException #
 * TODO Implement InvalidCourseActivityExceoption #
 *
 * Created by darthvader on 07.12.2016.
 */
public class Course {
    private int midtermMark;
    private int finalMark;
    private ArrayList<CourseActivity> activities = new ArrayList();
    private Teacher teacher;

    public int getMidtermMark() {
        return midtermMark;
    }

    public void setMidtermMark(int midtermMark) {
        this.midtermMark = midtermMark;
    }

    public int getFinalMark() {
        return finalMark;
    }

    public void setFinalMark(int finalMark) {
        this.finalMark = finalMark;
    }

    public float calculateTermMark() throws CourseActivityException {
        if(this.activityPercentageSum() == 100)
            throw new CourseActivityException("CourseActivity percentage sum is not 100");
        return (this.getMidtermMark() + this.getFinalMark())/2;
    }

    public void addActivity(CourseActivity activity) throws  CourseActivityException {
        if(this.containsActivity(activity)) throw new CourseActivityException("Same CourseActivity Object");
        if(this.containsActivityByName(activity)) throw new CourseActivityException("Same CourseActivity Name");
        if(this.activityPercentageSum() + activity.getPercentage() > 100)
            throw new CourseActivityException("CourseActivity percentage sum is more than 100");
        else this.activities.add(activity);
    }

    private int activityPercentageSum() {
        int sum = 0;
        for(CourseActivity ca : activities) sum += ca.getPercentage();
        return sum;
    }

    private boolean containsActivityByName(CourseActivity activity) {
        for(CourseActivity ca : activities){
            if(ca.getName().equals(activity.getName())) return true;
        }
        return false;
    }

    public boolean containsActivity(CourseActivity activity) {
        return this.activities.contains(activity);
    }

    public void assignTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public String getTeacherName() {
        return this.teacher.getName();
    }
}
