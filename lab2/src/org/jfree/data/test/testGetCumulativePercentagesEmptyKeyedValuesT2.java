package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;

import org.jfree.data.DataUtilities;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testGetCumulativePercentagesEmptyKeyedValuesT2 {

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
    public void testtestGetCumulativePercentagesEmptyKeyedValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals("Expected empty KeyedValues", 0, result.getItemCount());
    }

}
