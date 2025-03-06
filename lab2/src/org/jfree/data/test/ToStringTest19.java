package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ToStringTest19 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(0,100);
    }

    @Test
    public void testToString() {
        String expected = "Range (0,100)"; 
        assertEquals(expected, range.toString());
    }
}