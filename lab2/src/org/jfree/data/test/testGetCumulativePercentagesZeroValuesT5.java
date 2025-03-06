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

public class testGetCumulativePercentagesZeroValuesT5 {

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
    public void testZeroValueInData() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5);  // Explicitly specify Integer key and double value
        data.addValue(Integer.valueOf(1), 0);
        data.addValue(Integer.valueOf(2), 9);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        assertEquals("Cumulative percentage for key 0", 0.3571, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 1 (zero value)", 0.3571, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 2", 1.0, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
    }
}
