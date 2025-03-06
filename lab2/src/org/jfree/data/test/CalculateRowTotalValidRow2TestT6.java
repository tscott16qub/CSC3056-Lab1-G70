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

public class CalculateRowTotalValidRow2TestT6 {
    
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
        
        // Ensure rows are created in sequential order
        values2D.addValue(1, 0, 0); // Row 0, Column 0
        values2D.addValue(0, 0, 1); // Row 0, Column 1
        values2D.addValue(7, 0, 2); // Row 0, Column 2

        values2D.addValue(2, 1, 0); // Row 1, Column 0
        values2D.addValue(3, 1, 1); // Row 1, Column 1
        values2D.addValue(5, 1, 2); // Row 1, Column 2

        values2D.addValue(1, 2, 0); // Row 2, Column 0
        values2D.addValue(0, 2, 1); // Row 2, Column 1
        values2D.addValue(7, 2, 2); // Row 2, Column 2
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testCalculateRowTotalValidRow2() {
        assertEquals("Expected row 2 sum: 8", 8.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
    }
}
