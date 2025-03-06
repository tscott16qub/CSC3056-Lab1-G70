package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateColumnTotalNullValuesColumn0Test8 {

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

	@Test
    public void testColumnWithNullValuesColumn0() {
        DefaultKeyedValues2D values2D = new DefaultKeyedValues2D();
        values2D.addValue(2, 0, 0);
        values2D.addValue(4, 1, 0);
        values2D.addValue(null, 2, 0);

        assertEquals("Wrong sum returned for column with null values. Expected: 6", 
                6.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }

}
