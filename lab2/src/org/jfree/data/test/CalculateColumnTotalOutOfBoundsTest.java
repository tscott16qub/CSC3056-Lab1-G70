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

public class CalculateColumnTotalOutOfBoundsTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }
//Testcase7
    @Test
    public void testCalculateColumnTotalOutOfBoundsTest() {
        DefaultKeyedValues2D values2D = new DefaultKeyedValues2D();
        values2D.addValue(2, 0, 0);
        values2D.addValue(5, 1, 0);
        values2D.addValue(3, 2, 0);

        try {
            double result = DataUtilities.calculateColumnTotal(values2D, 5);
            assertEquals("Expected sum for out-of-bounds column is 0.0", 0.0, result, 0.0000001d);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
}
