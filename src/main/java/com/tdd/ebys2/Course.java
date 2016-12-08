package com.tdd.ebys2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

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

    public String calculateTermGrade() {
        float mark = this.calculateTermMark();
        if((mark >= 0) && (mark <= 38)) return "FF";
        else if (mark<=45) return "FD";
        else if (mark<=52) return "DD";
        else if (mark<=59) return "DC";
        else if (mark<=66) return "CC";
        else if (mark<=73) return "CB";
        else if (mark<=80) return "BB";
        else if (mark<=87) return "BA";
        else if (mark<=100) return "AA";
        else return null;
    }
}
