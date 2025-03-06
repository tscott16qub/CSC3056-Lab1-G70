package org.jfree.data.test;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.Before;
import org.junit.Test;

public class ContainsMiddleValueTest5 {
	//Testing a vale right in the middle of the range

	private Range range;
	
	@Before
	public void setUp() {
        range = new Range(10.0, 20.0);
    }

	@Test
    public void testMiddleOfRange() {
        boolean result = range.contains(15.0);
        assertEquals(true, result);
    }
}