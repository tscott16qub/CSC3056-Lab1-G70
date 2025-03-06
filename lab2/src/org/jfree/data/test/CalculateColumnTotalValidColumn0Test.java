package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues2D;
import org.jfree.data.Values2D;
import org.junit.Test;

import junit.framework.TestCase;

import static org.junit.Assert.*;


import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CalculateColumnTotalValidColumn0Test extends TestCase {

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
//Testcase 4
	@Test
    public void testCalculateColumnTotalValidColumn0() {
        DefaultKeyedValues2D values2D = new DefaultKeyedValues2D();
        values2D.addValue(2, 0, 0);
        values2D.addValue(4, 1, 0);
        values2D.addValue(1, 2, 0);

        assertEquals("Wrong sum returned. Expected: 7", 
                7.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }

}
