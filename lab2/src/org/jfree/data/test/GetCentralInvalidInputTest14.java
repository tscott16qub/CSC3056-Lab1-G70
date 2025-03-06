package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class GetCentralInvalidInputTest14 {
	
    private Range range;

    @Before
    public void setUp() {
        range = null; 
    }

    @Test
    public void testNullInput() {
        try {
            Double result = null;
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Input cannot be null", e.getMessage());
        }
    }
}