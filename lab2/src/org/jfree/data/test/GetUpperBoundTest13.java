package org.jfree.data.test;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.jfree.data.Range;

public class GetUpperBoundTest13 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(0, 100);
    }

    @Test
    public void testUpperBoundary() {
        assertEquals(100, range.getLength(), 0.001);
    }
}