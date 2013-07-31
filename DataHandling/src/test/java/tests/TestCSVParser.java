package tests;

import static org.junit.Assert.*;

import org.junit.Test;



import dataObjects.Data;
import dataObjects.MovingWindowData;

import utils.CSVParser;
import utils.IOUtils;

public class TestCSVParser {
	double[][] data = {{1, 1}, {2, 1}, {3, 1},{4, 1},{5, 1},{6, 1},{7, 1},{8, 1},{9, 1},{10, 1},{11, 1},{12, 1},{13, 1},{14, 1},{15, 1}} ;
	int[] dimensions = {15,2};
	int window = 5;
	
	@Test
	public void test() {
		CSVParser test = new CSVParser();
		String csv = test.convertToCsv(data, dimensions);
		assertEquals("6.0,1.0\n", csv.substring(40, 48));
	}
	
	public void TestLargeMatrix(){
		System.out.println("hello");
		IOUtils get = new IOUtils();
		Data data = get.openFile("H:/MScProject/data/id012noTs.txt");
		MovingWindowData mwData = new MovingWindowData(data.getData(), data.getDimensions(), 90);
		CSVParser test = new CSVParser();
		System.out.println(mwData.getDimensions().toString());
		String csv = test.convertToCsv(mwData.getData(), mwData.getDimensions());
		
		System.out.println(csv);
		
		assertNotNull(mwData);
	}
}	
