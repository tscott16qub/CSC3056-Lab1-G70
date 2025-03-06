package org.jfree.data.test;
import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalWithNullValuesRow0TestT7 {

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
    public void testCalculateRowTotalWithNullValuesRow0() {
        DefaultKeyedValues2D values2D = new DefaultKeyedValues2D();
        values2D.addValue(2, 0, 0);
        values2D.addValue(null, 0, 1);
        values2D.addValue(3, 0, 2);

        assertEquals("Expected row 0 sum ignoring nulls: 5", 5.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

}
