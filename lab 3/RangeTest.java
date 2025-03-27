package org.jfree.data;

import static org.junit.Assert.*;

import java.security.InvalidParameterException;

import org.jfree.data.Range;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RangeTest {
    private Range range;
    
    //Lab 2

    @Before
    public void setUp() throws Exception {
        range = new Range(-10, 10); // Initialised properly for consistency
    }

    @After
    public void tearDown() throws Exception {
        range = null;
    }

    @Test
    public void testCentralValueShouldBeZero() {
        assertEquals("The central value of -1 and 1 should be 0",
                0, new Range(-1, 1).getCentralValue(), 0.000000001d);
    }

    @Test
    public void testNaNInput() {
        try {
            range.contains(Double.NaN);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid input: NaN is not allowed", e.getMessage());
        }
    }

    @Test
    public void testUpperBoundary() {
        assertTrue(range.contains(10.0));
    }

    @Test
    public void testAboveUpperBoundary() {
        assertFalse(range.contains(11));
    }

    @Test
    public void testBelowUpperBoundary() {
        assertTrue(range.contains(9));
    }

    @Test
    public void testMiddleOfRange() {
        assertTrue(range.contains(0));
    }

    @Test
    public void testLowerBoundary() {
        assertTrue(range.contains(-10.0));
    }

    @Test
    public void testAboveLowerBoundary() {
        assertTrue(range.contains(-9));
    }

    @Test
    public void testBelowLowerBoundary() {
        assertFalse(range.contains(-11));
    }

    @Test
    public void testPositiveValue() {
        assertEquals(20, range.getLength(), 0.001);
    }

    @Test
    public void testNegativeValue() {
        Range negativeRange = new Range(-10, 0);
        assertEquals(10, negativeRange.getLength(), 0.001);
    }

    @Test
    public void testGetLowerBound() {
        assertEquals(-10, range.getLowerBound(), 0.001);
    }

    @Test
    public void testGetUpperBound() {
        assertEquals(10, range.getUpperBound(), 0.001);
    }

    @Test
    public void testConstructorWithInvalidBounds() {
        try {
            new Range(20, 10);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Lower bound cannot be greater than upper bound", e.getMessage());
        }
    }

    @Test
    public void testToString() {
        Range rangeForStringTest = new Range(0, 100);
        assertEquals("Range[0.0,100.0]", rangeForStringTest.toString());
    }
    
    //Lab 3
    
    //combine(Range, Range)

        @Test
        public void testBothRangesNull() {
            assertNull(Range.combine(null, null));
        }

        @Test
        public void testFirstRangeNull() {
            Range range2 = new Range(10, 20);
            assertEquals(range2, Range.combine(null, range2));
        }

        @Test
        public void testSecondRangeNull() {
            Range range1 = new Range(-10, 0);
            assertEquals(range1, Range.combine(range1, null));
        }

        @Test
        public void testOverlappingRanges() {
            Range range1 = new Range(5, 15);
            Range range2 = new Range(10, 20);
            Range expected = new Range(5, 20); 

            assertEquals(expected, Range.combine(range1, range2));
        }

        @Test
        public void testNonOverlappingRanges() {
            Range range1 = new Range(-20, -10);
            Range range2 = new Range(10, 20);
            Range expected = new Range(-20, 20); // Should combine both to cover full span

            assertEquals(expected, Range.combine(range1, range2));
        }
        
        
        //constrain(double)
        @Test
        public void testValueWithinRange() {
            Range range = new Range(10, 20);
            assertEquals(15, range.constrain(15), 0.0001);
        }

        @Test
        public void testValueBelowLowerBound() {
            Range range = new Range(10, 20);
            assertEquals(10, range.constrain(5), 0.0001);
        }

        @Test
        public void testValueAboveUpperBound() {
            Range range = new Range(10, 20);
            assertEquals(20, range.constrain(25), 0.0001);
        }

        @Test
        public void testValueAtLowerBound() {
            Range range = new Range(10, 20);
            assertEquals(10, range.constrain(10), 0.0001);
        }

        @Test
        public void testValueAtUpperBound() {
            Range range = new Range(10, 20);
            assertEquals(20, range.constrain(20), 0.0001);
        }
        
        //expand(Range, double, double)
        @Test
        public void testExpandNormalRange() {
            Range range = new Range(2, 6);
            Range expanded = Range.expand(range, 0.25, 0.5);
            assertEquals(new Range(1, 8), expanded);
        }

        @Test
        public void testExpandZeroMargins() {
            Range range = new Range(2, 6);
            Range expanded = Range.expand(range, 0, 0);
            assertEquals(range, expanded);
        }

        @Test
        public void testExpandNegativeMargins() {
            Range range = new Range(2, 6);
            Range expanded = Range.expand(range, -0.25, -0.5);
            assertEquals(new Range(3, 4), expanded);
        }

        @Test
        public void testExpandSinglePointRange() {
            Range range = new Range(5, 5);
            Range expanded = Range.expand(range, 0.2, 0.2);
            assertEquals(new Range(4, 6), expanded);
        }

        @Test(expected = IllegalArgumentException.class)
        public void testExpandNullRange() {
            Range.expand(null, 0.25, 0.5);
        }
        
        //expandToInclude
        @Test
        public void testExpandToIncludeWithinRange() {
            Range range = new Range(5, 10);
            Range expanded = Range.expandToInclude(range, 7);
            assertEquals(range, expanded); // Value is already in the range
        }

        @Test
        public void testExpandToIncludeLowerBound() {
            Range range = new Range(5, 10);
            Range expanded = Range.expandToInclude(range, 3);
            assertEquals(new Range(3, 10), expanded);
        }

        @Test
        public void testExpandToIncludeUpperBound() {
            Range range = new Range(5, 10);
            Range expanded = Range.expandToInclude(range, 12);
            assertEquals(new Range(5, 12), expanded);
        }

        @Test
        public void testExpandToIncludeNullRange() {
            Range expanded = Range.expandToInclude(null, 7);
            assertEquals(new Range(7, 7), expanded); // Should create a single-point range
        }

        @Test
        public void testExpandToIncludeExistingBound() {
            Range range = new Range(5, 10);
            Range expanded = Range.expandToInclude(range, 5);
            assertEquals(range, expanded); // No change expected
        }
        
        //shift(Range, double)
        @Test
        public void testShiftPositiveRangePositiveDelta() {
            Range range = new Range(5, 10);
            Range shifted = Range.shift(range, 3);
            assertEquals(new Range(8, 13), shifted);
        }

        @Test
        public void testShiftPositiveRangeNegativeDelta() {
            Range range = new Range(5, 10);
            Range shifted = Range.shift(range, -2);
            assertEquals(new Range(3, 8), shifted);
        }

        @Test
        public void testShiftNegativeRangePositiveDelta() {
            Range range = new Range(-10, -5);
            Range shifted = Range.shift(range, 4);
            assertEquals(new Range(-6, -1), shifted);
        }

        @Test
        public void testShiftNegativeRangeNegativeDelta() {
            Range range = new Range(-10, -5);
            Range shifted = Range.shift(range, -3);
            assertEquals(new Range(-13, -8), shifted);
        }

        @Test
        public void testShiftRangeIncludingZero() {
            Range range = new Range(-3, 3);
            Range shifted = Range.shift(range, 2);
            assertEquals(new Range(-1, 5), shifted);
        }

        @Test
        public void testShiftNullRangeThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> Range.shift(null, 2));
        }
        
        @Test
        public void testShiftZeroRange() {
            Range range = new Range(0, 0);
            Range shifted = Range.shift(range, 5);
            assertEquals(new Range(5, 5), shifted);
        }
        
        @Test
        public void testShiftLargeNumbers() {
            Range range = new Range(Double.MAX_VALUE - 10, Double.MAX_VALUE);
            Range shifted = Range.shift(range, 5);
            assertEquals(new Range(Double.MAX_VALUE - 5, Double.MAX_VALUE + 5), shifted);
        }
        
        //shift(Range, double, boolean)
        @Test
        public void testShift_NullBase_ThrowsException() {
            assertThrows(IllegalArgumentException.class, () -> Range.shift(null, 5.0, false));
        }
        
        @Test
        public void testShift_AllowZeroCrossing_PositiveShift() {
            Range range = new Range(2, 6);
            Range shifted = Range.shift(range, 3.0, true);
            assertEquals(new Range(5, 9), shifted);
        }
        
        @Test
        public void testShift_NoZeroCrossing_NegativeShift() {
            Range range = new Range(1, 5);
            Range shifted = Range.shift(range, -3.0, false);
            assertEquals(new Range(0, 2), shifted); // Prevents lower bound from going negative
        }
        
        @Test
        public void testShift_NoZeroCrossing_UpperBound() {
            Range range = new Range(-2, 3);
            Range shifted = Range.shift(range, -5, false);
            assertEquals(new Range(-7, 0), shifted); // Upper bound clamped at 0
        }
        
        @Test
        public void testShift_NoZeroCrossing_PreventNegative() {
            Range range = new Range(-5, -1);
            Range shifted = Range.shift(range, 3, false);
            assertEquals(new Range(0, 2), shifted); // Prevents lower bound from crossing zero
        }
        
        @Test
        public void testShift_AllowZeroCrossing_NegativeShift() {
            Range range = new Range(2, 6);
            Range shifted = Range.shift(range, -5, true);
            assertEquals(new Range(-3, 1), shifted); // No restriction on crossing zero
        }
        
        @Test
        public void testShift_ZeroLengthRange() {
            Range range = new Range(0, 0);
            Range shifted = Range.shift(range, 3.0, true);
            assertEquals(new Range(3, 3), shifted);
        }
        
        @Test
        public void testShift_LargeNumbers() {
            Range range = new Range(Double.MAX_VALUE - 10, Double.MAX_VALUE);
            Range shifted = Range.shift(range, 5, true);
            assertEquals(new Range(Double.MAX_VALUE - 5, Double.MAX_VALUE + 5), shifted);
        }
        
        //intersects(double lower, double upper)
        @Test
        public void testIntersects_OverlappingRanges() {
            Range range = new Range(2, 6);
            assertTrue(range.intersects(4, 8)); // Overlaps on (4,6)
        }

        @Test
        public void testIntersects_IdenticalRanges() {
            Range range = new Range(3, 7);
            assertTrue(range.intersects(3, 7)); // Exact match
        }

        @Test
        public void testIntersects_RangeInside() {
            Range range = new Range(2, 10);
            assertTrue(range.intersects(4, 6)); // Fully inside (4,6)
        }

        @Test
        public void testIntersects_BoundaryTouching() {
            Range range = new Range(5, 10);
            assertTrue(range.intersects(10, 15)); // Touches at 10
        }

        @Test
        public void testIntersects_NoIntersection() {
            Range range = new Range(1, 5);
            assertFalse(range.intersects(6, 10)); // Completely outside
        }

        @Test
        public void testIntersects_LeftTouch() {
            Range range = new Range(10, 20);
            assertTrue(range.intersects(5, 10)); // Touches at 10
        }

        @Test
        public void testIntersects_InvalidRange() {
            Range range = new Range(5, 15);
            assertFalse(range.intersects(10, 5)); // Invalid range (lower > upper)
        }

        @Test
        public void testIntersects_LargeNumbers() {
            Range range = new Range(Double.MAX_VALUE - 10, Double.MAX_VALUE);
            assertTrue(range.intersects(Double.MAX_VALUE - 5, Double.MAX_VALUE + 5));
        }
}





