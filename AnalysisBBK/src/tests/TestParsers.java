package tests;

import static org.junit.Assert.fail;

import java.util.ArrayList;

import org.junit.Test;

import utils.IOStringParser;
import utils.IOUtils;
import dataObjects.Data;

public class TestParsers {

	/*
	 * Check the object is created
	 */
	@Test
	public void testIOStringParser() {
		fail("Not yet implemented");
	}

	/*
	 * Split method assumptions * split results in same no. elements for each
	 * row; * split occurs in between numeric dataObject
	 */
	@Test
	public void testSpiltEqual() {
		fail("not yet implemented");
	}

	/*
	 * test that trailing spaces and other formating artifacts are not producing
	 * splits at the wrong places
	 */
	@Test
	public void testSpiltBetween() {
		fail("not yet implemented");
	}

	/*
	 * Parse to double array assumptions: * there is no non-numeric dataObject
	 */

	@Test
	// (expected = NumberFormatException.class)
	public void testSpiltException() {
		fail("not yet implemented");
	}

	/*
	 * Overall test
	 */
	@Test
	public void testIOStringParserWorks() {
		IOUtils open = new IOUtils();
		ArrayList<String> io = open.openFile("H:/id012test.txt");
		IOStringParser run = new IOStringParser();
		Data testData = run.parseToDouble(io, "\\s+");
	}

}
