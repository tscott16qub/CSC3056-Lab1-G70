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

public class CalculateRowTotalEmptyDataTestT2 {

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
    public void testCalculateRowTotalEmptyData() {
        Values2D values2D = new DefaultKeyedValues2D();  // Empty dataset
        assertEquals("Expected sum of empty row: 0", 0.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }

}
