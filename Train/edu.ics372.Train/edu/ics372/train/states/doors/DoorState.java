package edu.ics372.train.states.doors;

import edu.ics372.train.states.State;
import edu.ics372.train.timer.Notifiable;
import edu.ics372.train.timer.Timer;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class DoorState extends State implements Notifiable {
	protected Timer timer;

	/**
	 * Handle a door obstruction
	 */
	public void onObstruction() {

	}

}
