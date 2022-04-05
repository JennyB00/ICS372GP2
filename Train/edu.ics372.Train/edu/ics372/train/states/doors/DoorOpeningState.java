package edu.ics372.train.states.doors;

public class DoorOpeningState extends DoorState{
	private static DoorOpeningState instance;
	
	private DoorOpeningState() {
		instance = this;
	}
	
	public static DoorOpeningState getInstance() {
		if(instance == null) {
			instance = new DoorOpeningState();
		}
		return instance;
	}
	
	public void onDoorOpen() {
		DoorContext.instance().changeState(DoorOpenState.getInstance());
	}

	@Override
	public void enter() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
}
