package edu.ics372.train.states.doors;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class DoorState {
	public abstract void enter();
	
	public abstract void leave();
	
	public void onDoorClosed() {
		
	}
	
	public void onDoorClosing() {
		
	}
	
	public void onDoorOpen() {
		
	}
	
	public void onDoorOpening() {
		
	}
	
}
