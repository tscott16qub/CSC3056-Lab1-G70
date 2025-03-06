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

public class CalculateColumnTotalEmptyDataTest {

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
    public void testEmptyDataColumnTotal() {
        Values2D emptyValues = new DefaultKeyedValues2D();
        assertEquals("Wrong sum returned for empty data. Expected: 0", 
                0.0, DataUtilities.calculateColumnTotal(emptyValues, 0), 0.0000001d);
    }

}
