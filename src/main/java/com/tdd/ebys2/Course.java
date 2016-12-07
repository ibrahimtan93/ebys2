package com.tdd.ebys2;

/**
 * TODO Make midtermMark private #
 * TODO Make finalMark private #
 * TODO calculateTermMark = (midtermMark + finalMark)/2 #
 *
 * Created by darthvader on 07.12.2016.
 */
public class Course {
    private int midtermMark;
    private int finalMark;
    public String activity;

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

    public float calculateTermMark() {
        return (this.getMidtermMark() + this.getFinalMark())/2;
    }
}
