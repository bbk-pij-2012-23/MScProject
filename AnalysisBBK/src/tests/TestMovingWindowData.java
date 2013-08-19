/**
 * 
 */
package tests;

import org.junit.Test;

import dataObjects.MovingWindowData;

/**
 * @author emann06
 * 
 */
public class TestMovingWindowData {
	double[][] data = { { 1, 1 }, { 2, 1 }, { 3, 1 }, { 4, 1 }, { 5, 1 },
			{ 6, 1 }, { 7, 1 }, { 8, 1 }, { 9, 1 }, { 10, 1 }, { 11, 1 },
			{ 12, 1 }, { 13, 1 }, { 14, 1 }, { 15, 1 } };
	int[] dimensions = { 15, 2 };
	int window = 5;

	/*
	 * Assumptions to test: the object is created when the constructor is called
	 * a 2d array containing
	 */

	@Test
	public void testCreateSegments() {
		MovingWindowData testdata = new MovingWindowData(data, dimensions,
				window);
		System.out.println(testdata.toString());
	}

}
