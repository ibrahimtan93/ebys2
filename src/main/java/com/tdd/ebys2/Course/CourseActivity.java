package com.tdd.ebys2;

/**
 * Created by darthvader on 07.12.2016.
 */
public class CourseActivity {

    //TODO Need to remove mark object from course activity
    private final ActivityTypes activityType;
    private final int percentage;

    public CourseActivity(ActivityTypes activityType, int percentage) {
        this.activityType = activityType;
        this.percentage = percentage;
    }

    public ActivityTypes getType() { return activityType; }

    public int getPercentage() {
        return percentage;
    }
}
