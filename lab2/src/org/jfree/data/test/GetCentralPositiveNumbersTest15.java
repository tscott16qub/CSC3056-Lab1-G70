package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class GetCentralPositiveNumbersTest15 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(10,20);
    }

    @Test
    public void testTwoPositiveNumbers() {
        double result = range.getCentralValue();
        assertEquals(15, result, 0.001);
    }
}
