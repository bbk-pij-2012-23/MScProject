/*These are 'inelegant' tests, lots of repeated set up code - look into that.
 * 
 */


import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author eleanormann
 * 
 */
public class TestCalculator {
	Calculator<Integer> testCal;
	
	
	@Test
	public void test() {
		testCal = new Calculator<Integer>();
		assertNotNull(testCal);
	}
	
	
	/**
	 * test expected input results in expected output
	 */
	@Test
	public void testCountSameValue(){
		
		testCal = new Calculator<Integer>();
		int [] cardValues = {3,3,10,12,12};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		expected.add(12);
		ArrayList<Integer> output = testCal.sameValues(cardValues);
		assertEquals(expected, output);
	}
	
	/**
	 * test expected input results in expected output
	 * sameValues does not handle 3 or 4 same values well. It does id 3 and 4 (returns the value repeated
	 * for 3 and repeated 3 times for four of a kind. Its not pretty.
	 */
	@Test
	public void testSameValue3OAKind(){
		testCal = new Calculator<Integer>();
		int [] cardValues = {3,3,3,3,12};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		expected.add(3);
		expected.add(3);
		ArrayList<Integer> output = testCal.sameValues(cardValues);
		assertEquals(expected, output);
	}
	
	
	/**
	 * test for unexpected input:
	 * 
	 * - empty array
	 * 
	 * will not handle invalid card input as that would undermine independence of model from view
	 * 
	 * Not yet implemented - DOES NOT HANDLE EMPTY ARRAY YET
	 */
	@Test (expected = IllegalArgumentException.class)
	public void testErrorSameValue(){
		testCal = new Calculator<Integer>();
		int [] cardValues = {};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		ArrayList<Integer> output = testCal.sameValues(cardValues);
		assertEquals(expected, output);
	}
	
	
	/**
	 * test for unexpected input:
	 * - not integers (JQK type input)
	 * (to be tested elsewhere as it will throw an exception and not invoke method)
	 * 
	 * will not handle invalid card input as that would undermine independence of model from view
	 * 
	 */
	@Test
	public void testValuesNotInts(){
		fail("Not yet implemented");
	}
	
	/**
	 * test for expected results, incl multiple consecutives
	 *  
	 */
	@Test
	public void testConsecValues(){
		testCal = new Calculator<Integer>();
		int [] cardValues = {3,4,6,6,7};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(3);
		expected.add(4);
		expected.add(6);
		expected.add(7);
		ArrayList<Integer> output = testCal.consecValues(cardValues);
		assertEquals(expected,output);
	}
	
	@Test
	public void testHighValues(){
		testCal = new Calculator<Integer>();
		int [] cardValues = {3,4,6,12,1};
		ArrayList<Integer> expected = new ArrayList<Integer>();
		expected.add(12);
		expected.add(1);
		ArrayList<Integer> output = testCal.highValues(cardValues);
		assertEquals(expected,output);
	}
	
}
