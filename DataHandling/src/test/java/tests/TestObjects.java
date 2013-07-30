package tests;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import no.uib.cipr.matrix.Matrix;
import no.uib.cipr.matrix.io.MatrixVectorReader;

import org.junit.Before;
import org.junit.Test;

import utils.IOUtils;

import dataObjects.MatrixData;
import dataObjects.MovingWindowData;

public class TestObjects {

	@Test
	public void test() throws FileNotFoundException, IOException {
		Matrix tryit = new MatrixData(new MatrixVectorReader(new BufferedReader(new FileReader(new File("H:/id012.txt")))));
		assertNotNull(tryit);
	}
	
	
	@Test
	public void testMVReader() throws IOException{
		MatrixVectorReader testReader = new MatrixVectorReader(new BufferedReader(new FileReader(new File("H:/id012.txt"))));
		System.out.println(testReader.hasInfo());
		
	}
	
	@Test
	public void testMovingWindow() throws Exception {
		MovingWindowData testData = new MovingWindowData(new MatrixVectorReader(new BufferedReader(new FileReader(new File("H:/id012.txt")))), 90);
		assertNotNull(testData);
	}
	
	

}
