package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Test;

import analysis.CreateDataObjects;
import analysis.FixedCriteriaAnalysis;
import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.Subsequence;

/*
 * update to test refactoring 
 */
public class TestFixedCriteriaAnalysis {

	@Test
	public void testStartPeak() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.29 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		Data testData = new Data(data);
		Subsequence testPeak = new Subsequence(1);
		assertEquals(1, testPeak.getStart());

	}

	/*
	 * identify the true start of a rise identify the end of the rise identify
	 * duration of rise
	 */

	@Test
	public void testBoundaries() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.29 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		assertTrue(rise.getStart() == 3);
	}

	@Test
	public void testRiseEnd() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.29 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		assertTrue(rise.getEnd() == 5);
	}

	@Test
	public void testFallStart() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.29 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent fall = testRun.identifyFallBoundaries(0);
		assertTrue(fall.getStart() == 0);
	}

	/*
	 * What could go wrong? single time unit increase no change
	 */

	/*
	 * identify the max increase of any three consec values identify max of max
	 * increases set meetsCriteria to true if greater than 2
	 */

	@Test
	public void testStartValue() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.19 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		assertTrue(testRun.getSternalSkinConductance().getData()[rise
				.getStart()][1] == 1.19);
	}

	@Test
	public void testShortDurationCalcultions() {
		double[][] data = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.19 }, { 7.0, 1.27 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		FixedCriteriaAnalysis testRun2 = new FixedCriteriaAnalysis(testData);
		boolean isHf = testRun2.analyseRise(rise);
		assertTrue(((Subsequence) rise).getMaxIncrease() == 0.020000000000000018);
	}

	@Test
	public void testCalculateChanges() {
		double[][] data2 = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 1.21 }, { 6.0, 1.29 }, { 7.0, 1.31 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data2, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		FixedCriteriaAnalysis testRun2 = new FixedCriteriaAnalysis(testData);
		boolean isHf = testRun2.analyseRise(rise);
		assertTrue(((Subsequence) rise).getMaxIncrease() == 0.1200000000000001);
	}

	@Test
	public void testFindMaxChange() {
		double[][] data2 = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 2.21 }, { 6.0, 3.29 }, { 7.0, 4.31 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data2, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		FixedCriteriaAnalysis testRun2 = new FixedCriteriaAnalysis(testData);
		boolean isHf = testRun2.analyseRise(rise);
		assertTrue(isHf);
	}

	@Test
	public void testYValuesExist() {
		double[][] data2 = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 2.21 }, { 6.0, 3.29 }, { 7.0, 4.31 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data2, dims);
		FixedCriteriaAnalysis testRun2 = new FixedCriteriaAnalysis(testData);
		assertNotNull(testRun2.getYValues());
	}

	@Test
	public void testCorrectYValues() {
		double[][] data2 = { { 1.0, 1.57 }, { 2.0, 1.51 }, { 3.0, 1.41 },
				{ 4.0, 1.19 }, { 5.0, 2.21 }, { 6.0, 3.29 }, { 7.0, 4.31 },
				{ 8.0, 1.19 } };
		int[] dims = { 8, 1 };
		Data testData = new Data(data2, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent rise = testRun.identifyRiseBoundaries(0);
		FixedCriteriaAnalysis testRun2 = new FixedCriteriaAnalysis(testData);
		testRun2.updateYValues(rise);
		assertTrue(testRun2.getYValues().getData()[4][0] == 1);
	}

	@Test
	public void testExceptions() {
		fail();
	}

	/*
	 * peaks are compositions of rises and falls
	 */
	public void testIdentifyPeaks() {

	}
}
