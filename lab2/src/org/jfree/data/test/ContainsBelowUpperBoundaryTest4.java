package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsBelowUpperBoundaryTest4 {
	//Testing below the lower Boundary
	
	private Range range;

	@Before
	public void setUp() {
        range = new Range(10, 20);
    }

	@Test
    public void testBelowUpperBoundary() {
        boolean result = range.contains(19);
        assertEquals(true, result);
    }
}