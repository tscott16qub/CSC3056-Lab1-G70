package org.jfree.data.test;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

public class CalculateColumnTotalNullValuesColumn2Test9 {

    private DefaultKeyedValues2D values2D;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {}

    @AfterClass
    public static void tearDownAfterClass() throws Exception {}

    @Before
    public void setUp() throws Exception {
        values2D = new DefaultKeyedValues2D();
        values2D.addValue(3, 0, 0);  
        values2D.addValue(null, 1, 0);  
        values2D.addValue(7, 2, 0);  
    }

    @After
    public void tearDown() throws Exception {
        values2D = null;
    }

    @Test
    public void testCalculateColumnTotalNullValuesColumn2() {
    	double actualTotal = DataUtilities.calculateColumnTotal(values2D, 0);
        double expectedTotal = 10.0;
        
        assertEquals("Wrong sum returned for column with null values. Expected: 10",
                10.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }
}
