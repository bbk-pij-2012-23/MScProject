package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import dataObjects.Data;

import utils.IOStringParser;
import utils.IOUtils;

public class TestIOStringParser {

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
	
	/*
	 * having coupled this class with IOUtils it now only splits at whitespace
	 * need to change this so that csv and other data can be imported
	 */
	@Test
	public void testRightDelimiter(){
		fail("not yet implemented");
	}

	/*test that trailing spaces and other formating artifacts
	 * are not producing splits at the wrong places 
	 * this has been added to the IO module on reading in a String
	 * 
	 */
	@Test
	public void testSpiltBetween(){
		
		//assertEquals(2, dimensions[1]);
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
	
		
		Data testData = open.openFile("H:/id012test.txt");
		System.out.println(testData.toString());		
	}
	
}
