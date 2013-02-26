package newCode;

import oldCode.Room;
import newCode.DecoratedRoom;

public class DecoratedRoomWithSwitch extends DecoratedRoom {
	private String isLO;
	
	public DecoratedRoomWithSwitch(Room component) {
		super(component);
		isLO = "yes";
	}
	
	public String isLightOn() {
		// TODO Auto-generated method stub
		return isLO;
	}

}
