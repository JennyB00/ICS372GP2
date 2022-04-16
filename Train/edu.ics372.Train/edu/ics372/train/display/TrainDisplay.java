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

	public void showTimeLeftMessage(String message);

	public void showAccelerating();

	public void showDecelerating();

	public void showConstantSpeed();

	public void showDoorClosing();

	public void showDoorClosed();

	public void showDoorOpening();

	public void showDoorOpen();
}
