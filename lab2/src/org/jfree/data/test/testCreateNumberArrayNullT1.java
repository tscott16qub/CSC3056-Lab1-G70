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

public class testCreateNumberArrayNullT1 {

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
    public void testNullInputThrowsException() {
        try {
            DataUtilities.createNumberArray(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }

}
}
	
