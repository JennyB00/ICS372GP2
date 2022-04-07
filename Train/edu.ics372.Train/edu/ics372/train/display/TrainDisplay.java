package edu.ics372.train.display;

/**
 * 
 * @author Arun Markandu
 *
 */
public interface TrainDisplay {
	public void setStatusMessage(String message);
	
	public void showAccelerating();
	
	public void showDeaccelerating();
	
	public void showDoorOpening();
	
	public void showDoorClosing();
	
	public void showDoorReopening();
	
	public void showTimeLeft(int time);
	
}
