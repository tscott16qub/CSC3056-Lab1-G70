package org.jfree.data.test;

import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testCreateNumberArray2DMixedValuesT6Test {

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
    public void testCreateNumberArray2DMixedValues() {
        double[][] input = {{-1.2, 0.0}, {3.5, -2.8}};
        Number[][] expected = {{-1.2, 0.0}, {3.5, -2.8}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }

}
