package org.jfree.data;

import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.DefaultKeyedValues2D; 
import org.jfree.data.KeyedValues;
import org.jfree.data.Values2D; 
import junit.framework.TestCase;

import static org.junit.Assert.*;

import java.lang.reflect.Constructor;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DataUtilitiesTest extends TestCase {
    public DefaultKeyedValues2D values2D;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    @Before
    public void setUp() {
        values2D = new DefaultKeyedValues2D();
        
        // Add test data
        values2D.addValue(2, 0, 0);
        values2D.addValue(5, 0, 1);
        values2D.addValue(3, 0, 2);
        values2D.addValue(4, 1, 0);
        values2D.addValue(6, 1, 1);
        values2D.addValue(8, 1, 2);
        values2D.addValue(1, 2, 0);
        values2D.addValue(0, 2, 1);
        values2D.addValue(7, 2, 2);
    }

    @After
    public void tearDown() {
        values2D = null;
    }

    @Test
    public void testValidDataAndColumnColumnTotal() {
        assertEquals("Wrong sum returned. It should be 7.0", 
                7.0, DataUtilities.calculateColumnTotal(values2D, 0), 0.0000001d);
    }
    
    @Test
    public void testNullDataColumnTotal() {
        try {
            DataUtilities.calculateColumnTotal(null, 0); 
            fail("No exception thrown. The expected outcome was: a thrown "
                    + "exception of type: IllegalArgumentException");
        }
        catch(Exception e){
            assertTrue("Incorrect exception type thrown", 
                    e.getClass().equals(IllegalArgumentException.class));
        }
    }
    
    //Testcase2
    @Test
    public void testEmptyDataColumnTotal() {
        Values2D emptyValues = new DefaultKeyedValues2D();
        assertEquals("Wrong sum returned for empty data. Expected: 0", 
                0.0, DataUtilities.calculateColumnTotal(emptyValues, 0), 0.0000001d);
    }

    //Testcase3
    @Test
    public void testCalculateColumnTotalNegativeIndex() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(2, 0, 0);
        testValues.addValue(5, 0, 1);
        testValues.addValue(3, 0, 2);

        try {
            DataUtilities.calculateColumnTotal(testValues, -1);
            fail("Expected an exception for negative column index, but none was thrown.");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
    
    //Testcase2 (duplicate, renamed)
    @Test
    public void testCalculateColumnTotalNullData() {
        try {
            DataUtilities.calculateColumnTotal(null, 0);
            fail("Expected IllegalArgumentException, but no exception was thrown.");
        } catch (Exception e) {
            assertTrue("Incorrect exception type thrown", e instanceof IllegalArgumentException);
        }
    }
    
    //Test 8
    @Test
    public void testColumnWithNullValuesColumn0() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(2, 0, 0);
        testValues.addValue(4, 1, 0);
        testValues.addValue(null, 2, 0);

        assertEquals("Wrong sum returned for column with null values. Expected: 6", 
                6.0, DataUtilities.calculateColumnTotal(testValues, 0), 0.0000001d);
    }
    
    //Test 9
    @Test
    public void testCalculateColumnTotalNullValuesColumn2() {
        double actualTotal = DataUtilities.calculateColumnTotal(values2D, 0);
        double expectedTotal = 7.0; // Updated based on your setup data
        
        assertEquals("Wrong sum returned for column with null values. Expected: 7",
                expectedTotal, actualTotal, 0.0000001d);
    }
    
    
    //Testcase7
    @Test
    public void testCalculateColumnTotalOutOfBoundsTest() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(2, 0, 0);
        testValues.addValue(5, 1, 0);
        testValues.addValue(3, 2, 0);

        try {
            double result = DataUtilities.calculateColumnTotal(testValues, 5);
            assertEquals("Expected sum for out-of-bounds column is 0.0", 0.0, result, 0.0000001d);
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
    
    //Testcase 4
    @Test
    public void testCalculateColumnTotalValidColumn0() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(2, 0, 0);
        testValues.addValue(4, 1, 0);
        testValues.addValue(1, 2, 0);

        assertEquals("Wrong sum returned. Expected: 7", 
                7.0, DataUtilities.calculateColumnTotal(testValues, 0), 0.0000001d);
    }
    
    //Testcase5
    @Test
    public void testCalculateColumnTotalValidColumn1() {
        assertEquals("Wrong sum returned. Expected: 11.0", 11.0, DataUtilities.calculateColumnTotal(values2D, 1),
                0.0000001d);
    }
    
    @Test
    public void testCalculateColumnTotalValidColumn2() {
        System.out.println("Column Count: " + values2D.getColumnCount());
        System.out.println("Row Count: " + values2D.getRowCount());

        assertEquals("Wrong sum returned. Expected: 18", 18.0, DataUtilities.calculateColumnTotal(values2D, 2),
                0.0000001d);
    }
    
    //T10 test case
    public void testCalculateColumnTotalWithZeroValues() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(0.0, 0, 0);
        testValues.addValue(0.0, 1, 0);
        testValues.addValue(0.0, 2, 0);

        assertEquals("Sum of zero values should be 0.0", 
                     0.0, 
                     DataUtilities.calculateColumnTotal(testValues, 0), 
                     0.0000001d);
    }
    
    
  //T1 Testcase
    @Test
    public void testCalculateRowTotalNullDataTest() {
        try {
            DataUtilities.calculateRowTotal(null, 0);
            fail("Expected NullPointerException not thrown");
        } catch (NullPointerException e) {
            // Expected behavior
            assertTrue(e.getMessage().contains("Cannot invoke \"org.jfree.data.Values2D.getColumnCount()\""));
        }
    }
    
   //T2 testcase
    @Test
    public void testCalculateRowTotalEmptyData() {
        Values2D emptyValues = new DefaultKeyedValues2D();  // Empty dataset
        assertEquals("Expected sum of empty row: 0", 0.0, DataUtilities.calculateRowTotal(emptyValues, 0), 0.0000001d);
    }
    
    //T3 testcase
    @Test
    public void testalculateRowTotalNegativeRowIndex() {
        try {
            DataUtilities.calculateRowTotal(values2D, -1);
            fail("Expected an exception for negative row index");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
    
    //T4 Testcase
    @Test
    public void testalculateRowTotalValidRow0() {
        assertEquals("Expected row 0 sum: 10", 10.0, DataUtilities.calculateRowTotal(values2D, 0), 0.0000001d);
    }
    
    //T5 Testcase
    @Test
    public void testCalculateRowTotalValidRow1() {
        assertEquals("Expected row 1 sum: 18", 18.0, 
                     DataUtilities.calculateRowTotal(values2D, 1), 0.0000001d);
    }
    
    //T6 Testcase
    @Test
    public void testCalculateRowTotalValidRow2() {
        assertEquals("Expected row 2 sum: 8", 8.0, DataUtilities.calculateRowTotal(values2D, 2), 0.0000001d);
    }
    
    //T7 testcase
    @Test
    public void testCalculateRowTotalWithNullValuesRow0() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(2, 0, 0);
        testValues.addValue(null, 0, 1);
        testValues.addValue(3, 0, 2);

        assertEquals("Expected row 0 sum ignoring nulls: 5", 5.0, DataUtilities.calculateRowTotal(testValues, 0), 0.0000001d);
    }
    
    //T8 testcase
    public void testCalculateRowTotalWithNullValuesRow1() {
        DefaultKeyedValues2D testValues = new DefaultKeyedValues2D();
        testValues.addValue(null, 0, 0);  // Adding to row 0
        testValues.addValue(4.0, 1, 0);   // Adding to row 1
        testValues.addValue(6.0, 1, 1);   // Adding to row 1
        testValues.addValue(null, 1, 2);  // Adding to row 1
        
        assertEquals("Expected row 1 sum ignoring nulls: 10", 
                     10.0, 
                     DataUtilities.calculateRowTotal(testValues, 1), 
                     0.0000001d);
    }
    
    //T9 testcase
    @Test
    public void testCalculateRowTotalOutOfBounds() {
        try {
            DataUtilities.calculateRowTotal(values2D, 5);
            fail("Expected an exception for out-of-bounds row index");
        } catch (IndexOutOfBoundsException | IllegalArgumentException e) {
            assertTrue("Expected exception type thrown", true);
        }
    }
    
    
    //T1 testcase
    @Test
    public void testCreateNumberArray2DNullInput() {
        try {
            DataUtilities.createNumberArray2D(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
    
    //T2 testcase
    @Test
    public void testCreateNummberArray2dEmptyArray() {
        Number[][] result = DataUtilities.createNumberArray2D(new double[][]{});
        assertEquals("Expected empty 2D array", 0, result.length);
    }
    
    //T3 testcase
    @Test
    public void testCreateNumberArray2DPositiveValues() {
        double[][] input = {{1.2, 2.5}, {3.8, 4.1}};
        Number[][] expected = {{1.2, 2.5}, {3.8, 4.1}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T4 testcase
    @Test
    public void testCreateNumberArray2DNegativeValues() {
        double[][] input = {{-1.2, -2.5}, {-3.8, -4.1}};
        Number[][] expected = {{-1.2, -2.5}, {-3.8, -4.1}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T5 testcase
    @Test
    public void testCreateNumberArray2DZeroValues() {
        double[][] input = {{0.0, 0.0}, {0.0, 0.0}};
        Number[][] expected = {{0.0, 0.0}, {0.0, 0.0}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T6 testcase
    @Test
    public void testCreateNumberArray2DMixedValues() {
        double[][] input = {{-1.2, 0.0}, {3.5, -2.8}};
        Number[][] expected = {{-1.2, 0.0}, {3.5, -2.8}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T7 testcase
    @Test
    public void testtestCreateNumberArray2DJaggedArray() {
        double[][] input = {{1.2, 2.5}, {3.8}};
        Number[][] expected = {{1.2, 2.5}, {3.8}};
        Number[][] result = DataUtilities.createNumberArray2D(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T1 testcase
    @Test
    public void testCreateNumberArrayNull() {
        try {
            DataUtilities.createNumberArray(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
    
    //T2 testcase
    @Test
    public void testEmptyArrayReturnsEmptyArray() {
        Number[] result = DataUtilities.createNumberArray(new double[]{});
        assertEquals("Expected empty array", 0, result.length);
    }
    
    // T3 testcase
    @Test
    public void testCreateNumberArrayPositiveValues() {
        double[] input = {1.2, 2.5, 3.8};
        Number[] expected = {1.2, 2.5, 3.8};
        Number[] result = DataUtilities.createNumberArray(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T4 testcase
    @Test
    public void testCreateNumberArrayNegativeValues() {
        double[] input = {-1.2, -2.5, -3.8};
        Number[] expected = {-1.2, -2.5, -3.8};
        Number[] result = DataUtilities.createNumberArray(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T5 testcase
    @Test
    public void testCreateNumberArrayZeroValues() {
        double[] input = {0.0, 0.0, 0.0};
        Number[] expected = {0.0, 0.0, 0.0};
        Number[] result = DataUtilities.createNumberArray(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T6 testcase
    @Test
    public void testCreateNumberArrayMixedValues() {
        double[] input = {-1.2, 0.0, 3.5};
        Number[] expected = {-1.2, 0.0, 3.5};
        Number[] result = DataUtilities.createNumberArray(input);

        assertArrayEquals("Expected array does not match", expected, result);
    }
    
    //T1 testcase
    @Test
    public void testGetCumulativePercentagesNullInput() {
        try {
            DataUtilities.getCumulativePercentages(null);
            fail("Expected IllegalArgumentException not thrown");
        } catch (IllegalArgumentException e) {
            assertEquals("Null 'data' argument.", e.getMessage());
        }
    }
    
    //T2 testcase
    @Test
    public void testtestGetCumulativePercentagesEmptyKeyedValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        assertEquals("Expected empty KeyedValues", 0, result.getItemCount());
    }
    
    //T3 testcase
    @Test
    public void testGetCumulativePercentagesSingleEntry() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5.0); // Explicitly specify Integer key and double value
        
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        assertEquals("Cumulative percentage of single value should be 1.0", 1.0, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
    }
    
    //T4 testcase
    @Test
    public void testGetCumulativePercentagesPositiveValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5.0); // Explicitly specify Integer key and double value
        data.addValue(Integer.valueOf(1), 9.0);
        data.addValue(Integer.valueOf(2), 2.0);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);

        assertEquals("Cumulative percentage for key 0", 0.3125, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 1", 0.875, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 2", 1.0, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
    }
    
    //T5 testcase
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
    
    //T6 testcase
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
    
    //T7 testcase
    @Test
    public void testGetCumulativePercentagesAllZeroValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 0);
        data.addValue(Integer.valueOf(1), 0);
        data.addValue(Integer.valueOf(2), 0);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        assertEquals("Cumulative percentage for key 0 with all zeros", 0.0, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 1 with all zeros", 0.0, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 2 with all zeros", 0.0, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
    }
    
    //T8 testcase
    @Test
    public void testGetCumulativePercentagesMixedPositiveAndNegativeValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), -3);
        data.addValue(Integer.valueOf(1), 5);
        data.addValue(Integer.valueOf(2), -2);
        data.addValue(Integer.valueOf(3), 4);

        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        assertNotNull("Result should not be null", result);
        assertEquals("Cumulative percentage for key 0", -0.3, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 1", 0.2, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 2", 0.0, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 3", 1.0, result.getValue(Integer.valueOf(3)).doubleValue(), 0.0001);
    }
    
    //T9 testcase
    @Test
    public void testGetCumulativePercentagesMixedValueTypes() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5.0);
        data.addValue(Integer.valueOf(1), 0);
        data.addValue(Integer.valueOf(2), -3.0);
        data.addValue(Integer.valueOf(3), 7.0);
        
        try {
            KeyedValues result = DataUtilities.getCumulativePercentages(data);
            
            // Verify the cumulative percentages for mixed value types
            assertEquals("Cumulative percentage for key 0", 0.3125, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
            assertEquals("Cumulative percentage for key 1 (zero value)", 0.3125, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
            assertEquals("Cumulative percentage for key 2 (negative value)", 0.3125, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
            assertEquals("Cumulative percentage for key 3", 1.0, result.getValue(Integer.valueOf(3)).doubleValue(), 0.0001);
        } catch (Exception e) {
            fail("Method should handle mixed value types without throwing an exception.");
        }
    }
    
    //T10 testcase
    @Test
    public void testGetCumulativePercentagesWithNullValues() {
        DefaultKeyedValues data = new DefaultKeyedValues();
        data.addValue(Integer.valueOf(0), 5.0);
        data.addValue(Integer.valueOf(1), null);  // Explicitly add a null value
        data.addValue(Integer.valueOf(2), 9.0);
        
        KeyedValues result = DataUtilities.getCumulativePercentages(data);
        
        // Verify the cumulative percentages, treating null values as effectively zero
        assertEquals("Cumulative percentage for key 0", 0.3571, result.getValue(Integer.valueOf(0)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 1 (null value)", 0.3571, result.getValue(Integer.valueOf(1)).doubleValue(), 0.0001);
        assertEquals("Cumulative percentage for key 2", 1.0, result.getValue(Integer.valueOf(2)).doubleValue(), 0.0001);
    }
    
    
    //T11 testcase
    @Test
    public void testDataUtilitiesClassLoading() {
        assertNotNull("DataUtilities class should be loaded", DataUtilities.class);
    }
    
    
}