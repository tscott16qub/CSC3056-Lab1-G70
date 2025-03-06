package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsBelowLowerBoundary8 {
	private Range range;

    @Before
    public void setUp() {
        range = new Range(10, 20);
    }

    @Test
    public void testBelowLowerBoundary() {
        boolean result = range.contains(9);
        assertEquals(false, result);
    }
}
