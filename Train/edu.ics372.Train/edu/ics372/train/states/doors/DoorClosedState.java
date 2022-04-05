package edu.ics372.train.states.doors;

public class DoorClosedState extends DoorState{
	private static DoorClosedState instance;
	
	private DoorClosedState() {
		instance = this;
	}
	
	public static DoorClosedState getInstance() {
		if(instance == null) {
			instance = new DoorClosedState();
		}
		return instance;
	}
	
	public void onDoorOpening() {
		DoorContext.instance().changeState(DoorOpeningState.getInstance());
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
