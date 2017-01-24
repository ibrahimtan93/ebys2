package com.tdd.ebys2;

/**
 * Created by darthvader on 07.12.2016.
 */
public class CourseActivity {

    private final ActivityTypes activityType;
    private final int percentage;
    private Mark mark;

    public CourseActivity(ActivityTypes activityType, int percentage) {
        this.activityType = activityType;
        this.percentage = percentage;
    }

    public ActivityTypes getType() { return activityType; }

    public int getPercentage() {
        return percentage;
    }

    public void setMark(float mark) throws MarkException {
        this.mark = new Mark(mark);
    }

    public float getMark() {
        return this.mark.getMark();
    }
}
