package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsUpperBoundaryTest2 {
	//Contains Upper Boundary test
	private Range range;

	@Before
	public void setUp() {
		range = new Range(10,20);
	}

	@Test
    public void testUpperBoundary() {
        boolean result = range.contains(20.0);
        assertEquals(true, result);
    }
}
