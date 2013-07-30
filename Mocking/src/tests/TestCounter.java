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
		Integer mockedFirst;
		Integer expectedFirst = 1;
		
		//create a real instance of Counter
		Counter count = new Counter();
		
		//create an instance of a mock Counter
		Counter mockedCounter = mock(Counter.class);
		
		//when Counter object calls its getValue method return 1, then 2 next time
		when(mockedCounter.getValue()).thenReturn(1).thenReturn(2);
		
		//compare what happens when the two objects call their getValue methods
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		
		assertEquals("Wrong Answer!", first, mockedFirst);
		
		//now repeat
		first = count.getValue();
		mockedFirst = mockedCounter.getValue();
		
		assertEquals("Wrong Answer!", first, mockedFirst);
		
		//now tell it to expect at least 4 repeats (there are only two)
		//now change it to two and it should pass (it does)
		verify(mockedCounter,atLeast(2)).getValue();
		
		//try other verifies
		verify(mockedCounter, atLeastOnce()).getValue();
		//verify(mockedCounter,never()). getValue();
		verify(mockedCounter,atMost(4)). getValue();
		
		
	}


}
