package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class GetLengthInvalidInputTest9 {
    private Range range;

    @Before
    public void setUp() {
        range = null; 
    }

    @Test
    public void testNullInput() {
        try {
            Double result = range.getLength();
            fail("Expected NullPointerException not thrown");
        } catch (NullPointerException e) {
            assertEquals("Null input", e.getMessage());
        }
    }
}
