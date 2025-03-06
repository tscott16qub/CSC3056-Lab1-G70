package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalOutOfBoundsTestT9 {
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

        values2D.addValue(2, 0, 0);
        values2D.addValue(5, 0, 1);
        values2D.addValue(3, 0, 2);
        values2D.addValue(4, 1, 0);
        values2D.addValue(6, 1, 1);
        values2D.addValue(8, 1, 2);
        values2D.addValue(1, 2, 0);
        values2D.addValue(0, 2, 1);
        values2D.addValue(7, 2, 2);
    }

    @After
    public void tearDown() {
        values2D = null;
    }

    @Test
    public void testCalculateRowTotalOutOfBounds() {
        assertThrows("Expected IndexOutOfBoundsException for out-of-bounds row index",
                IndexOutOfBoundsException.class, 
                () -> DataUtilities.calculateRowTotal(values2D, 5));
    }
}
