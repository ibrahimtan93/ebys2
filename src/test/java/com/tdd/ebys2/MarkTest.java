package com.tdd.ebys2;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by darthvader on 23.01.2017.
 */
public class MarkTest {
    @Test
    public void createMarkTest(){
        //Fixture setup..
        Mark mark = new Mark(100);

        //Verify..
        assertTrue("Failed to create \"Mark\" object.", mark instanceof Mark);
    }
}
