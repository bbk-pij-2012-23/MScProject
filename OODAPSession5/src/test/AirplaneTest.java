package test;

import static org.junit.Assert.*;

import org.junit.Test;

import vehicles.Airplane;

public class AirplaneTest {

	@Test
	public void test() {
		String expectedOutput = "Like a fighter jet";
		String stringReturned = null;
		
		Airplane classUnderTest = new Airplane(1);
		stringReturned = classUnderTest.howDoYouFly();
		assertEquals("Wrong Answer!", stringReturned, expectedOutput);
		//fail("Not yet implemented");
	}

	@Test
	public void test2() {
		String expectedOutput = "Vertically";
		String stringReturned = null;
		Airplane classUnderTest = new Airplane(1);
		stringReturned = classUnderTest.howDoYouLiftOff();
		assertEquals("Wrong Answer!", stringReturned, expectedOutput);
	}
}

