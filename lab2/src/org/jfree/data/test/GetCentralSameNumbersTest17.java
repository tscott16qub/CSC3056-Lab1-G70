package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class GetCentralSameNumbersTest17 {
    private Range range;

    @Before
    public void setUp() {
        range = new Range(10,10);
    }

    @Test
    public void testSameNumbers() {
        double result = range.getCentralValue();
        assertEquals(10.0, result, 0.001);
    }}
