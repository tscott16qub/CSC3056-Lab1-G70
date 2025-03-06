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

public class CalculateRowTotalNegativeRowIndexTestT3 {

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
    public void testalculateRowTotalNegativeRowIndex() {
        Values2D values2D = new DefaultKeyedValues2D();
        assertEquals("Expected sum for negative row index: 0", 0.0, DataUtilities.calculateRowTotal(values2D, -1), 0.0000001d);
    }

}
