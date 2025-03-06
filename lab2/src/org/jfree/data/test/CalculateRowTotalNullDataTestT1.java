package org.jfree.data.test;
import static org.junit.Assert.*;

import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalNullDataTestT1 extends TestCase{

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
	public void testCalculateRowTotalNullDataTest() {
	    try {
	        DataUtilities.calculateRowTotal(null, 0);
	        fail("Expected NullPointerException not thrown");
	    } catch (NullPointerException e) {
	        
	    }
	}
}
