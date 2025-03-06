package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateColumnTotalNullDataTest {

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
//Testcase2
	@Test
    public void testCalculateColumnTotalNullData() {
        try {
            DataUtilities.calculateColumnTotal(null, 0);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e instanceof IllegalArgumentException);
        }
    }

}
