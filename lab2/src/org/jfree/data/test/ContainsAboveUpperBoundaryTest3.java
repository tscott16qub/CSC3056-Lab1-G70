package org.jfree.data.test;

import static org.junit.Assert.*; 
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsAboveUpperBoundaryTest3 {
	//Contains above the upper boundary test
	
	private Range range;

	@Before
	public void setUp() {
		range = new Range(10, 20);
	}

	@Test
    public void testAboveUpperBoundary() {
        boolean result = range.contains(21);
        assertEquals(false, result);
    }
}
