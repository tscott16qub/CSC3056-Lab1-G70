package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GetCentralInvalidBoundsTest18 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(20,10);
    }

    @Test
    public void testConstructorWithInvalidBounds() {
        try {
            new Range(20, 10);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Lower bound cannot be greater than upper bound", e.getMessage());
        }
    }}