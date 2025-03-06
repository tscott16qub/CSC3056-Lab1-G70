package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class GetLengthPositiveTest10 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(0, 10); // A valid range from 0 to 10
    }

    @Test
    public void testPositiveValue() {
        assertEquals(10, range.getLength(), 0.001);
    }
}
