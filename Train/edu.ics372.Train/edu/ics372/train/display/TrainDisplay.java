package edu.ics372.train.display;

/**
 * 
 * @author Arun Markandu
 * 
 *         This interface provide the APIs for the GUI class. All these API
 *         methods should be implemented by the GUI class.
 */
public interface TrainDisplay {
	public void setStatusMessage(String message);

	public void showTimeLeft(int time);

	public void showAccelerating();

	public void showConstantSpeed();

	public void showDecelerating();

	public void showArrived();

	public void showDoorOpening();

	public void showDoorOpen();

	public void showDoorClosing();

	public void showDoorObstruction();

	public void showDoorClosed();
}
