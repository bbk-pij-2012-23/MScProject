package tests;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import resources.PrintUtils;

import utils.IOUtils;
import dataObjects.ClusteredSegment;
import dataObjects.Data;

public class TestSegmentData {
	private static ClusteredSegment test;
	
	@BeforeClass
	public static void open(){
		IOUtils get = new IOUtils();
		Data data = get.openFile("H:/MScProject/data/ClusteredSegment012.txt");
		test = new ClusteredSegment(data);
	}
	
	@Test
	public void testClusteredSegmentFields() {
		int[] dimensions = {500, 3};
		//System.out.println(PrintUtils.printMatrix(test.getData(), dimensions));
		assertNotNull(test.getData());
		assertNotNull(test.getDimensions());
	}
	
	@Test
	public void testDefinedSegmentSizes(){
		test.defineSegmentSizes();
		System.out.println(test.getSegmentCutpoints().size());
	}
	
	@Test
	public void testSetSegmentedDataDimensions(){
		if(test.getSegmentedData()==null){
			test.setSegmentedDataDimensions();
			test.createClusterSegments();
		}
		
		assertNotNull(test.getSegmentedData());
	}
	
	

}
