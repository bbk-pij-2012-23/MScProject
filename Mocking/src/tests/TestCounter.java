package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import code.Counter;
import static org.mockito.Mockito.*;

public class TestCounter {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testCounter() {
		Integer first;
		Integer expectedFirst =1;
		Counter count = new Counter();
		first = count.getValue();
		assertEquals("Wronge Answer !",expectedFirst, first);
		
	}


}
