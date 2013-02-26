package tests;

import static org.junit.Assert.*;

import oldCode.BedRoom;

import org.junit.Test;

public class RoomTest {

	@Test
	public void test() {
		String expectedResult = "BedRoom";
		String actualResult = null;
		BedRoom classUnderTest = new BedRoom();
		actualResult = classUnderTest.whatKindOfRoomAreYou();
		assertEquals("Wrong answer! ", expectedResult, actualResult);
	}

}
