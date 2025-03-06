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

public class testGetCumulativePercentagesSingleEntryT3 {

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
    public void testGetCumulativePercentagesSingleEntry() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5.0); // Explicitly specify Integer key and double value
        
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        assertEquals("Cumulative percentage of single value should be 1.0", 1.0, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
    }

}
