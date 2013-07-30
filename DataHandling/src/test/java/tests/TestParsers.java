package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataObjects.Data;

import utils.IOStringParser;
import utils.IOUtils;

public class TestParsers {

	/* Check the object is created
	 * 
	 */
	@Test
	public void testIOStringParser() {
		fail("Not yet implemented");
	}

	/* Split method assumptions
	 * * split results in same no. elements for each row;
	 * * split occurs in between numeric data
	 * 
	 * 
	 * 
	 */
	@Test
	public void testSpiltEqual(){
		fail("not yet implemented");
	}
	

	
	@Test
	public void testSpiltBetween(){
		fail("not yet implemented");
	}
	
	/*Parse to double array assumptions:
	 * * there is no non-numeric data
	 * 
	 */
			
	@Test //(expected = NumberFormatException.class)
	public void testSpiltException(){
		fail("not yet implemented");
	}
	
	/* Overall test 
	 * 
	 * 	 */
	@Test 
	public void testIOStringParserWorks(){
		IOUtils open = new IOUtils();
		ArrayList<String> io = open.openFile("H:/id012test.txt");
		IOStringParser run = new IOStringParser();
		Data testData = run.parseToDouble(io, "\\s+");
		System.out.println(testData.toString());		
	}
	
}
