package edu.ics372.train.states.doors;

public class DoorClosingState extends DoorState{
	private static DoorClosingState instance;
	
	private DoorClosingState() {
		instance = this;
	}
	
	public static DoorClosingState getInstance() {
		if(instance == null) {
			instance = new DoorClosingState();
		}
		return instance;
	}
	
	@Override
	public void onDoorClosed() {
		DoorContext.instance().changeState(DoorClosedState.getInstance());
	}

	@Override
	public void enter() {
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	
	
}
