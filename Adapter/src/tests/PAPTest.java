package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.PAP;

public class PAPTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expectedAnswer = "A person";
		String actualAnswer;
		PAP classUnderTest = new PAP();
		actualAnswer = classUnderTest.youWho();
		assertEquals("Wrong Answer!", expectedAnswer, actualAnswer);
	}

}
