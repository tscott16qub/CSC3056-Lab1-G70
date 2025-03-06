package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculateColumnTotalNegativeIndexTest {

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() throws Exception {
    }
//Testcase3
    @Test
    public void testCalculateColumnTotalNegativeIndex() {
        DefaultKeyedValues2D values2D = new DefaultKeyedValues2D();
        values2D.addValue(2, 0, 0);
        values2D.addValue(5, 0, 1);
        values2D.addValue(3, 0, 2);

        try {
            DataUtilities.calculateColumnTotal(values2D, -1);
            fail("Expected an exception for negative column index, but none was thrown.");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
}
