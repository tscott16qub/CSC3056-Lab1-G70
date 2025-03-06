package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateColumnTotalValidColumn2Test {

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

		// Ensure at least 3 columns exist
		values2D.addValue(1, 0, 0); // Row 0, Column 0
		values2D.addValue(2, 1, 0); // Row 1, Column 0

		values2D.addValue(4, 0, 1); // Row 0, Column 1
		values2D.addValue(5, 1, 1); // Row 1, Column 1

		// Now add column 2 values
		values2D.addValue(3, 0, 2); // Row 0, Column 2
		values2D.addValue(8, 1, 2); // Row 1, Column 2
		values2D.addValue(7, 2, 2); // Row 2, Column 2
	}

	@After
	public void tearDown() throws Exception {
		values2D = null;
	}

	@Test
	public void testCalculateColumnTotalValidColumn2() {
		System.out.println("Column Count: " + values2D.getColumnCount());
		System.out.println("Row Count: " + values2D.getRowCount());

		assertEquals("Wrong sum returned. Expected: 18", 18.0, DataUtilities.calculateColumnTotal(values2D, 2),
				0.0000001d);
	}
}
