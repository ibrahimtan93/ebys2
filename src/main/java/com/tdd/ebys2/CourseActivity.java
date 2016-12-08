package com.tdd.ebys2;

/**
 * TODO Refactor this to extract as interface for different types of activities
 *
 * Created by darthvader on 07.12.2016.
 */
public class CourseActivity {
    private final String name;
    private final int percentage;

    public CourseActivity(String activityName, int percentage) {
        this.name = activityName;
        this.percentage = percentage;
    }

    public String getName() {
        return name;
    }

    public int getPercentage() {
        return percentage;
    }
}
