package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.Range;

public class GetLowerBoundTest12 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(-100, 0);
    }

    @Test
    public void testLowerBoundary() {
        assertEquals(100, range.getLength(), 0.001);
    }
}
