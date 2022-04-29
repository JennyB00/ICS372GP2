package edu.ics372.train.display;

/**
 * This interface provide the APIs for the GUI class. All these API methods
 * should be implemented by the GUI class.
 * 
 * @author Arun Markandu
 */
public interface TrainDisplay {
	/**
	 * Updates the status field to the given String
	 * 
	 * @param message The String to write
	 */
	public void setStatusMessage(String message);

	/**
	 * Updates the timer value shown in the timer field, along with the current
	 * timer details
	 * 
	 * @param time int timer value
	 */
	public void showTimeLeft(int time);

	/**
	 * Updates the status and timer details to accelerating
	 */
	public void showAccelerating();

	/**
	 * Updates the status and timer details to constant speed
	 */
	public void showConstantSpeed();

	/**
	 * Updates the status and timer details to de-accelerating
	 */
	public void showDecelerating();

	/**
	 * Updates the status and timer details to arrived
	 */
	public void showArrived();

	/**
	 * Updates the status and timer details to door opening
	 */
	public void showDoorOpening();

	/**
	 * Updates the status and timer details to door open
	 */
	public void showDoorOpen();

	/**
	 * Updates the status and timer details to door closing
	 */
	public void showDoorClosing();

	/**
	 * Updates the status and timer details to re-opening door after obstruction
	 * event
	 */
	public void showDoorReOpening();

	/**
	 * Updates the status and timer details to door closed
	 */
	public void showDoorClosed();
}
