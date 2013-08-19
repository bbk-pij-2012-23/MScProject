package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import org.junit.Test;

import analysis.CreateDataObjects;
import analysis.FixedCriteriaAnalysis;
import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.Peak;

public class TestPeaks {

	@Test
	public void createPeak() {
		Peak testPeak = new Peak();
		assertNotNull(testPeak);
	}

	@Test
	public void testGetRises() {
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
				{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
				{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
				{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent testPeak = testRun.identifyPeak(0, 0.10);
		int i = 0;
		System.out.println("peak end: " + testPeak.getEnd());
		while(i<testPeak.getEnd()){
			System.out.println(testRun.getSternalSkinConductance().getData()[i][1]);
			i++;
		}
		assertNotNull(((Peak) testPeak).getSubsequences());
	}

	@Test
	public void testSetRises() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
				{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
				{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
				{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		DataComponent testData = new Data(data, dims);
		DataComponent testPeak = new Peak();
		testPeak.add(testData);
		DataComponent dataOutput = testPeak.getDataComponent(0);
		int length = ((Data) dataOutput).getDimensions()[0];
		assertEquals(13, length);
		
	}

	@Test (expected= IndexOutOfBoundsException.class)
	public void testRemove() {
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
				{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
				{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
				{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		DataComponent testData = new Data(data, dims);
		DataComponent testPeak = new Peak();
		testPeak.add(testData);
		assertNotNull(testPeak.getDataComponent(0));
		testPeak.remove(testData);
		assertNotNull(testPeak.getDataComponent(0));
	}

	

	@Test
	public void testDisplayInfo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testAddOutcomesColumn(){
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
				{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
				{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
				{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		DataComponent testData = new Data(data, dims);
		DataComponent testPeak = new Peak();
		testPeak.setStart(0);
		testPeak.setEnd(13);
		FixedCriteriaAnalysis testrun = new FixedCriteriaAnalysis((Data) testData);
		
		testrun.updateYValues(testPeak);
		assertEquals(1, testrun.getYValues().getData()[3][0],1e-8);
		
	}


	
}
