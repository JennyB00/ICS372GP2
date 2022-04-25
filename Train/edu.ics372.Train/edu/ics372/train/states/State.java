package edu.ics372.train.states;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class State {
	/**
	 * Runs upon entering this state
	 */
	public abstract void enter();

	/**
	 * Runs upon exiting this state
	 */
	public abstract void leave();
}
