package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by prometheus on 1/23/17.
 */
public class MarkTest {
    @Test
    public void createMarkTest(){
        Mark mark = new Mark(100);

        assertTrue("Failed to create \"mark\" object.", mark instanceof Mark);
    }

    @Test
    public void getMarkTest(){
        Mark mark = new Mark(50);
        assertEquals("Failed to get mark",50,mark.getMark(),.2);
    }

    @Test
    public void calculateGradeTest(){
        Mark mark = new Mark(60);
        assertEquals("Failed to calculate Grade","CC",mark.calcGrade());
    }
}
