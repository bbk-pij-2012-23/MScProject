/**
 * 
 */
package newCode;

import oldCode.Room;

/**
 * @author emann06
 *
 */
public class DecoratedRoomWithDoor extends DecoratedRoom {

	private String doorOpen;

	public DecoratedRoomWithDoor(Room component) {
		super(component);
		doorOpen = "Shut that door!";
	}
	
	public String ifDoorOpen(){
		return doorOpen;
	}

}
