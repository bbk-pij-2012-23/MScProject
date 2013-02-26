package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.AnotherPerson;
import example.Nosrep;

public class AnotherPersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expectedAnswer = "A person";
		String actualAnswer;
		AnotherPerson classUnderTest = new Nosrep();
		actualAnswer = classUnderTest.youWho();
		assertEquals("Wrong Answer!", expectedAnswer, actualAnswer);
	}

}
