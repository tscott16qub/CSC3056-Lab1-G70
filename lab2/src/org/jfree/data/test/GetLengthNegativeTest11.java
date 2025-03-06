package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.Range;

public class GetLengthNegativeTest11 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(-10, 0); // A range from -10 to 0
    }

    @Test
    public void testNegativeValue() {
        assertEquals(10, range.getLength(), 0.001);
    }
}