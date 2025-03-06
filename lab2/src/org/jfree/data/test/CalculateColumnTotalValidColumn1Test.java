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

public class CalculateColumnTotalValidColumn1Test {

	private DefaultKeyedValues2D values2D;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		values2D = new DefaultKeyedValues2D();

		// Ensure that multiple columns exist
		values2D.addValue(5, 0, 0); // Row 0, Column 0
		values2D.addValue(6, 1, 0); // Row 1, Column 0
		values2D.addValue(0, 2, 0); // Row 2, Column 0

		values2D.addValue(3, 0, 1); // Row 0, Column 1
		values2D.addValue(4, 1, 1); // Row 1, Column 1
		values2D.addValue(5, 2, 1); // Row 2, Column 1
		
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
	}
//Testcase5
	@Test
	public void testCalculateColumnTotalValidColumn1() {
		assertEquals("Wrong sum returned. Expected: 12.0", 12.0, DataUtilities.calculateColumnTotal(values2D, 1),
				0.0000001d);
	}
}
