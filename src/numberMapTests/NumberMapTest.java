package numberMapTests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import numberMap.InvalidNumberMapCoordinateException;
import numberMap.InvalidNumberMapSizeException;
import numberMap.NumberMap;

/**
 * JUnit tests for the NumberMap class.
 * @author Ken Loomis
 */
public class NumberMapTest {

	/** Number Map of size 1 **/
	private NumberMap nm1; 
	/** Number Map of size 5 **/
	private NumberMap nm5;
	
	@Before
	public void setUp() throws Exception 
	{
		
		nm1 = new NumberMap(1);
		nm5= new NumberMap(5);
	}

	/**
	 * Tests for the NumberMap constructor:
	 * Test0a-b: Test the correct instantiation of 2 NumberMaps
	 * Test1: Test the instantiation of a NumberMap of size 0.
	 * Test2: Test the instantiation of a NumberMap of size -3 
	 */
	@Test
	public void testNumberMap() 
	{
		// Test 0a
		assertNotNull (nm1);
		// Test 0b
		assertNotNull (nm5);
		
		// Test 1
		NumberMap nmBad;
		try {
			nmBad = new NumberMap (0);
			fail();
		}
		catch ( InvalidNumberMapSizeException e)
		{
			assertEquals ("The given size (0) is not a valid size.", e.getMessage());
		}
		
		// Test 2
		try {
			nmBad = new NumberMap (-3);
			fail();
		}
		catch ( InvalidNumberMapSizeException e)
		{
			assertEquals ("The given size (-3) is not a valid size.", e.getMessage());
		}
	}

	/**
	 * Test the getSize method for a NumberMap:
	 * Test0a-b: Tested for valid sizes
	 */
	@Test
	public void testGetSize() 
	{
		// Test 0a
		assertEquals(1, nm1.getSize());
		// Test 0b
		assertEquals(5, nm5.getSize());
	}
	
	/**
	 * Test the at  method for a NumberMap:
	 * Test0a-b: Tests valid indexes of a NumberMap to see if they return a reasonable number
	 * Test1a-d: Test combinations of invalid indexes. 
	 * 
	 */
	@Test
	public void testAt() 
	{
		int value;
		// Test 0a
		try {
			value = nm1.at(0,0);
			assertTrue(value >= 0 && value< 100);
		} catch (InvalidNumberMapCoordinateException e) {
			fail();
		}
		
		// Test 0b
		try {
			value = nm5.at(0,0);
			assertTrue(value >= 0 && value< 100);
		} catch (InvalidNumberMapCoordinateException e) {
			fail();
		}
		
		// Test 1a: Negative row value
		try {
			value = nm5.at(-1,0);
			fail();
		} catch (InvalidNumberMapCoordinateException e) {
			assertEquals ( "The given coordiantes (-1, 0) is not valid.", e.getMessage());
		}
		
		// Test 1b: Negative column value
		try {
			value = nm5.at(0,-1);
			fail();
		} catch (InvalidNumberMapCoordinateException e) {
			assertEquals ( "The given coordiantes (0, -1) is not valid.", e.getMessage());
		}
		
		// Test 1c: Row value too high
		try {
			value = nm5.at(5,0);
			fail();
		} catch (InvalidNumberMapCoordinateException e) {
			assertEquals ( "The given coordiantes (5, 0) is not valid.", e.getMessage());
		}
		
		// Test 1d: Column value too high
		try {
			value = nm5.at(0,5);
			fail();
		} catch (InvalidNumberMapCoordinateException e) {
			assertEquals ( "The given coordiantes (0, 5) is not valid.", e.getMessage());
		}
		
	}
	
	/**
	 * Test the rowSums  method for a NumberMap:
	 * Test0a-b: Tests the row sums of a NumberMap to see if they result in a reasonably sized array
	 * (i.e the array is the same size as the NumberMap).
	 * 
	 */
	@Test
	public void testRowSums()
	{
		// Test 0a:
		assertEquals(nm1.getSize(), nm1.rowSums().length);
		
		// Test 0b:
		assertEquals(nm5.getSize(), nm5.rowSums().length);
	}
	
	/**
	 * Test the colSums  method for a NumberMap:
	 * Test0a-b: Tests the column sums of a NumberMap to see if they result in a reasonably sized array
	 * (i.e the array is the same size as the NumberMap).
	 * 
	 */
	@Test
	public void testColSums()
	{
		// Test 0a:
		assertEquals(nm1.getSize(), nm1.colSums().length);
		
		// Test 0b:
		assertEquals(nm5.getSize(), nm5.colSums().length);
	}
	
	/**
	 * Test the findMinimum  method for a NumberMap:
	 * Test0: Tests that the minimum location of a number map of size 1
	 * is found at index 0,0 (i.e. the only possible value)
	 * 
	 */
	@Test
	public void testFindMinimum()
	{
		// Test 0:
		Point min = nm1.findMinimum();
		assertEquals(0, min.x);
		assertEquals(0, min.y);
	}
	
	/**
	 * Test the findMinimum  method for a NumberMap:
	 * Test0: Tests that the minimum location of a number map of size 1
	 * is found at index 0,0 (i.e. the only possible value)
	 * 
	 */
	@Test
	public void testFindMaximum()
	{
		// Test 0:
		Point min = nm1.findMaximum();
		assertEquals(0, min.x);
		assertEquals(0, min.y);
	}
	
}
