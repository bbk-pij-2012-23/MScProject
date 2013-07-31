/**
 * 
 */
package tests;

import static org.junit.Assert.*;


import java.util.ArrayList;


import org.junit.Test;

import resources.PrintUtils;

import utils.IOUtils;

import dataObjects.Data;
import dataObjects.MovingWindowData;

/**
 * @author emann06
 *
 */
public class TestMovingWindowData {
	double[][] data = {{1, 1}, {2, 1}, {3, 1},{4, 1},{5, 1},{6, 1},{7, 1},{8, 1},{9, 1},{10, 1},{11, 1},{12, 1},{13, 1},{14, 1},{15, 1}} ;
	int[] dimensions = {15,2};
	int window = 5;

	
	/*Assumptions to test:
	 * the object is created when the constructor is called
	 * a 2d array containing 
	 * 
	 */

	
	
	@Test
	public void testCreateSegments() {
		MovingWindowData testdata = new MovingWindowData(data,dimensions, window);
		System.out.println(testdata.toString());
	}
	
	/* 0.183seconds to create ~8000*90 matrix
	 * 3.57seconds to create and print to screen 500 rows
	 */
	@Test
	public void testCreateSegmentsLargeDataset(){
		IOUtils get = new IOUtils();
		Data data = get.openFile("H:/MScProject/data/id012noTs.txt");
		MovingWindowData mwData = new MovingWindowData(data.getData(), data.getDimensions(), 90);
		PrintUtils printPart = new PrintUtils();
		get.writeAFile("H:/testout.txt", mwData.getData().toString());
		assertNotNull(mwData);
	}

}
