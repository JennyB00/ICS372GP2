package edu.ics372.train.states.doors;

import edu.ics372.train.timer.Notifiable;
import edu.ics372.train.timer.Timer;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class DoorState implements Notifiable {
	protected Timer timer;

	/**
	 * Runs upon entering this state
	 */
	public abstract void enter();

	/**
	 * Runs upon exiting this state
	 */
	public abstract void leave();

	/**
	 * Handle a door obstruction
	 */
	public void onObstruction() {

	}

}
