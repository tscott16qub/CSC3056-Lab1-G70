package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsLowerBoundaryTest6 {
//Testing the lower Boundary value of the range
	
	private Range range;
	
	@Before
    public void setUp() {
        range = new Range(10, 20);
    }

	@Test
    public void testLowerBoundary() {
        boolean result = range.contains(10.0);
        assertEquals(true, result);
    }
}