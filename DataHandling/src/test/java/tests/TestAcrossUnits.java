package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.Test;

import dataObjects.Data;
import dataObjects.MovingWindowData;

import utils.CSVParser;
import utils.IOStringParser;
import utils.IOUtils;

public class TestAcrossUnits {

	
	private String printMatrix(double[][] matrix, int[] dimensions){
		String printout = "";
		for(int rows = 0; rows < dimensions[0]; rows++){
			for(int cols = 0; cols < dimensions[1]; cols++){
				printout = printout + matrix[rows][cols] + " ";
			}
			printout = printout + "\n";
		}
		
		return printout;
	}
	
	@Test
	public void commandLineInput(){
		System.out.println("Type in path and filename>>");
		System.out.println(">> ");
		Scanner input = new Scanner(System.in);
		String filename = input.nextLine();
	}
	/*currently .2 seconds to create moving window data
	 * 
	 */
	
	
	
	@Test
	public void testIOAndCreateData() {
		IOUtils getData = new IOUtils();
		
		String filename = "H:/MScProject/data/id012noTs.txt";
		Data data = getData.openFile(filename);
		
		MovingWindowData mwData = new MovingWindowData(data.getData(), data.getDimensions(), 90);
		CSVParser parseToCsv = new CSVParser();
		String csv = parseToCsv.convertToCsv(mwData.getData(), mwData.getDimensions());
		getData.writeAFile("H:/testoutput.txt", csv);		
		assertNotNull(mwData);
	}
	
	

}
