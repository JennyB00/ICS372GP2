package edu.ics372.train.states.doors;

public class DoorOpenState extends DoorState{
	private static DoorOpenState instance;
	
	/**
	 * 
	 */
	private DoorOpenState() {
		instance = this;
	}
	
	/**
	 * 
	 * 
	 * @return the object
	 */
	public static DoorOpenState getInstance() {
		if(instance == null) {
			instance = new DoorOpenState();
		}
		return instance;
	}
	
	@Override
	public void onDoorClosing() {
		DoorContext.instance().changeState(DoorClosingState.getInstance());
	}
	
	@Override
	public void enter() {
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub
		
	}
	

}
