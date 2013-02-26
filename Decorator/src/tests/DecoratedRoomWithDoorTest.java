package tests;

import static org.junit.Assert.*;

import newCode.DecoratedRoomWithDoor;
import newCode.DecoratedRoomWithSwitch;
import oldCode.BedRoom;

import org.junit.Test;

public class DecoratedRoomWithDoorTest {

	@Test
	public void test() {
		String expectedResult = "Shut that door!";
		String actualResult = null;
		DecoratedRoomWithDoor classUnderTest = new DecoratedRoomWithDoor(new BedRoom());
		actualResult = classUnderTest.ifDoorOpen();
		assertEquals("Wrong answer! ", expectedResult, actualResult);
	}

}
