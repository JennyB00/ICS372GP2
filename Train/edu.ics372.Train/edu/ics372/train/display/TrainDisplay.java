package edu.ics372.train.display;

/**
 * 
 * @author Arun Markandu
 *
 */
public interface TrainDisplay {
	public void setStatusMessage(String message);

	public void showArrived();

	public void showApproaching();

	public void showDoorObstruction();

	public void showTimeLeft(int time);

	public void showAccelerating();

	public void showDecelerating();

	public void showConstantSpeed();

	public void showDoorClosing();

	public void showDoorClosed();

	public void showDoorOpening();

	public void showDoorOpen();
	
	public void showTimeLeftDoorOpening(int time);
	
	public void showTimeLeftDoorReOpening(int time);
	
	public void showTimeLeftDoorClosing(int time);
	
	public void showTimeLeftApproaching(int time);
	
	public void showTimeLeftAccelerating(int time);
	
	public void showTimeLeftDecelerating(int time);
}
