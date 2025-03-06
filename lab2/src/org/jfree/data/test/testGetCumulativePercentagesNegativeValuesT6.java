package org.jfree.data.test;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.KeyedValues;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class testGetCumulativePercentagesNegativeValuesT6 {

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
    public void testGetCumulativePercentagesNegativeValues() {
		DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), -5); // Explicitly specify Integer key and double value
        data.addValue(Integer.valueOf(1), -9);
        data.addValue(Integer.valueOf(2), 2);

        try {
            DataUtilities.getCumulativePercentages(data);
        } catch (Exception e) {
            fail("Method should handle negative values considerately without throwing an exception.");
        }
    }
}
