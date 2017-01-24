package com.tdd.ebys2;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by prometheus on 1/24/17.
 */
public class Enrollment {
    private final Course course;
    private final Student student;
    private HashMap<CourseActivity, Mark> activityMarkMap;

    public Enrollment(Course course, Student student) {
        this.course = course;
        this.student = student;
        this.activityMarkMap = new HashMap<CourseActivity, Mark>();
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setActivityMark(CourseActivity activity, Mark mark) {
        if(!this.activityMarkMap.containsKey(activity))
            this.activityMarkMap.put(activity, mark);
    }

    public Mark getActivityMark(CourseActivity activity) {
        if(this.activityMarkMap.containsKey(activity)) return this.activityMarkMap.get(activity);
        return null;
    }

    public Mark getTermMark() throws MarkException {
        float sum = 0;
        Mark mark;
        CourseActivity activity;
        Map.Entry mentry;
        Set set = activityMarkMap.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()) {
            mentry = (Map.Entry)iterator.next();
            activity = (CourseActivity) mentry.getKey();
            mark = (Mark) mentry.getValue();
            sum += (mark.getMark() * activity.getPercentage())/100;
        }
        return new Mark(sum);
    }
}
