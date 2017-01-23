package com.tdd.ebys2;

/**
 * TODO Refactor this to extract as abstract class for different types of activities #
 * TODO Abstract Factory #
 * TODO type field for typechecking #
 * TODO include Mark for the activity
 * Created by darthvader on 07.12.2016.
 */
public abstract class CourseActivity {
    private final int percentage;
    private final String type;
    private Mark mark;

    public CourseActivity(int percentage, String type) {
        this.percentage = percentage;
        this.type = type;
    }

    public void setMark(float mark) throws MarkException {
        this.mark = new Mark(mark);
    }

    public float getMark() {
        return this.mark.getMark();
    }

    public int getPercentage() {
        return percentage;
    }

    public String getType() { return type; }

    public static FinalExam FINALEXAM(int percentage){
        return new FinalExam(percentage);
    }

    public static MidtermExam MIDTERMEXAM(int percentage){
        return new MidtermExam(percentage);
    }

    public static Homework HOMEWORK(int percentage){
        return new Homework(percentage);
    }

    public static Presentation PRESENTATION(int percentage){
        return new Presentation(percentage);
    }

    public static Project PROJECT(int percentage){
        return new Project(percentage);
    }
}
