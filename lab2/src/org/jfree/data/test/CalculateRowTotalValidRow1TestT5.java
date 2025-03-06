package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateRowTotalValidRow1TestT5 {
    
    private DefaultKeyedValues2D values2D; 

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() {
        values2D = new DefaultKeyedValues2D(); 

        
        values2D.addValue(0, 0, 0); // Dummy row 0
        values2D.addValue(4, 1, 0); // Row 1, Column 0
        values2D.addValue(6, 1, 1); // Row 1, Column 1
        values2D.addValue(8, 1, 2); // Row 1, Column 2
    }

    @After
    public void tearDown() throws Exception {
        values2D = null;
    }

    @Test
    public void testCalculateRowTotalValidRow1() {
        assertEquals("Expected row 1 sum: 18", 18.0, 
                     DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
    }
}

