package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.AnotherPerson;
import example.Nosrep;

public class OtherTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expectedAnswer;
		String actualAnswer;
		
		actualAnswer = classUnderTest.youWho();
		assertEquals("Wrong Answer!", expectedAnswer, actualAnswer);
	}

}
