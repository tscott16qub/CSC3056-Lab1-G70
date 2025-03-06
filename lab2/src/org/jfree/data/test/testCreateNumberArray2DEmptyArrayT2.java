package org.jfree.data.test;
import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testCreateNumberArray2DEmptyArrayT2 {

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
    public void testCreateNummberArray2dEmptyArray() {
        Number[][] result = DataUtilities.createNumberArray2D(new double[][]{});
        assertEquals("Expected empty 2D array", 0, result.length);
    }

}
