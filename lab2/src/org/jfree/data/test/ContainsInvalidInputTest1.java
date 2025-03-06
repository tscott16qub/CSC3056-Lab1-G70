package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;


	public class ContainsInvalidInputTest1 {
	    private Range range;

	    @Before
	    public void setUp() {
	        range = new Range(10, 20);
	    }

	    @Test
	    public void testNaNInput() {
	        try {
	            range.contains(Double.NaN);
	            fail("Expected IllegalArgumentException not thrown");
	        } catch (IllegalArgumentException e) {
	            assertEquals("Invalid input: NaN is not allowed", e.getMessage());
	        }
	    }
	}

