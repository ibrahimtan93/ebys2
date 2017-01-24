package com.tdd.ebys2;

/**
 * Created by prometheus on 1/23/17.
 */
public class Mark {
    private final float mark;

    public Mark(float mark) throws MarkException {
        if(mark < 0 || mark > 100)
            throw new MarkException("Invalid Mark Range..! ");
        this.mark = mark;
    }

    public float getMark() {
        return mark;
    }

    public String getGrade() {
            float mark = this.getMark();
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
