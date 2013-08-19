package tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import analysis.CreateDataObjects;
import analysis.FixedCriteriaAnalysis;

import utils.CSVParser;
import utils.IOStringParser;
import utils.IOUtils;
import utils.PrintUtils;
import dataObjects.Data;
import dataObjects.DataComponent;
import dataObjects.MovingWindowData;
import dataObjects.Peak;

public class TestAcrossUnits {

	private String printMatrix(double[][] matrix, int[] dimensions) {
		String printout = "";
		for (int rows = 0; rows < dimensions[0]; rows++) {
			for (int cols = 0; cols < dimensions[1]; cols++) {
				printout = printout + matrix[rows][cols] + " ";
			}
			printout = printout + "\n";
		}

		return printout;
	}

	/*
	 * currently .2 seconds to create moving window dataObject
	 */
	@Test
	public void testIOAndCreateData() {
		IOUtils getData = new IOUtils();
		String filename = "014.txt";
		ArrayList<String> stringData = getData.openFile(filename);
		IOStringParser parse = new IOStringParser();
		Data data = parse.parseToDouble(stringData, "\\s+");
		
		/*MovingWindowData mwData = new MovingWindowData(data.getData(),
				data.getDimensions(), 90);
		CSVParser csv = new CSVParser();
		String csvData = csv.convertToCsv(mwData.getData(),
				mwData.getDimensions());
		*/
		assertNotNull(data);
	}
	
	@Test
	public void testCreateAndAnalysePeaks(){
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
				{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
				{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
				{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent testPeak = testRun.identifyPeak(0, 0.10);
		
		FixedCriteriaAnalysis testAnalysis = new FixedCriteriaAnalysis(testData);
		boolean isHF = false;
		for(int i = 0; i< ((Peak) testPeak).getSubsequences().size(); i++){
			isHF = testAnalysis.analyseRise(testPeak.getDataComponent(i));
			if(isHF==true){
				break;
			}
		}
		assertTrue(isHF);
	}
	
	@Test
	public void analyseAndUpdateYValues(){
		double[][] data = { { 1.0, 1.41 }, { 2.0, 1.19 }, { 3.0, 2.21 },
					{ 4.0, 3.29 }, { 5.0, 4.31 }, { 6.0, 1.19 }, { 7.0, 1.20 },
					{ 8, 1.22 }, { 9, 1.57 }, { 10, 1.51 }, { 11, 1.15 },
					{ 12, 1.19 }, { 13, 1.12 } };
		int[] dims = {13,2};
		Data testData = new Data(data, dims);
		CreateDataObjects testRun = new CreateDataObjects(testData);
		DataComponent testPeak = testRun.identifyPeak(0, 0.10);
		FixedCriteriaAnalysis testAnalysis = new FixedCriteriaAnalysis(testData);
		boolean isHF = testAnalysis.analyseRise(testPeak.getDataComponent(0));
		testAnalysis.updateYValues(testPeak);
		for(int i = 0; i< testAnalysis.getYValues().getData().length; i++){
			System.out.println(testAnalysis.getYValues().getData()[i][0]);
		}
	}
}
