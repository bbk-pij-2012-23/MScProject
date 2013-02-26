package tests;

import static org.junit.Assert.*;

import oldCode.BedRoom;
import oldCode.LivingRoom;
import oldCode.Room;
import oldCode.Room1;

import org.junit.Test;

public class RoomTest {

	@Test
	public void test() {
		String expectedResult = "BedRoom";
		String actualResult = null;
		Room1 classUnderTest = new BedRoom();
		actualResult = classUnderTest.whatKindOfRoomAreYou();
		assertEquals("Wrong answer! ", expectedResult, actualResult);
	}
	
	@Test
	public void test2() {
		String expectedResult = "LivingRoom";
		String actualResult = null;
		Room1 classUnderTest = new LivingRoom();
		actualResult = classUnderTest.whatKindOfRoomAreYou();
		assertEquals("Wrong answer! ", expectedResult, actualResult);
	}

}
