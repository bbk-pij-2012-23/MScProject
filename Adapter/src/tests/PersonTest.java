package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import example.Person;

public class PersonTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void test() {
		String expectedAnswer = "A person";
		String actualAnswer;
		Person classUnderTest = new Person ();
		actualAnswer = classUnderTest.whoAreYou();
		assertEquals("Wrong Answer!", expectedAnswer, actualAnswer);
	}

}
