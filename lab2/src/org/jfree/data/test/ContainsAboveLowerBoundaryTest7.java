package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsAboveLowerBoundaryTest7 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(10, 20);
    }

    @Test
    public void testAboveLowerBoundary() {
        boolean result = range.contains(11);
        assertEquals(true, result);
    }
}