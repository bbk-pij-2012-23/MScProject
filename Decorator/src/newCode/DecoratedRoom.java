package newCode;

import oldCode.Room;

public class DecoratedRoom extends Room {
	Room component;
	
	/**
	 * @param component
	 */
	public DecoratedRoom(Room component) {
		super();
		this.component = component;
	}

	@Override
	public String whatKindOfRoomAreYou() {
		// TODO Auto-generated method stub
		return component.whatKindOfRoomAreYou();
	}

}
