package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculateRowTotalWithNullValuesRow1TestT8 {

    private DefaultKeyedValues2D values2D;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() {
        values2D = new DefaultKeyedValues2D();

        // Ensuring correct row key order (0, 1, ...)
        values2D.addValue(3, 0, 0);  // Row 0, Column 0
        values2D.addValue(5, 0, 1);  // Row 0, Column 1

        values2D.addValue(4, 1, 0);  // Row 1, Column 0
        values2D.addValue(6, 1, 1);  // Row 1, Column 1
        values2D.addValue(null, 1, 2);  // Row 1, Column 2 (null should be ignored)
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateRowTotalWithNullValuesRow1() {
        assertEquals("Expected row 1 sum ignoring nulls: 10", 
                     10.0, 
                     DataUtilities.calculateRowTotal(values2D, 1), 
                     0.0000001d);
    }
}

