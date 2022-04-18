package edu.ics372.train.states.running;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class RunningState {
	public abstract void enter();

	public abstract void leave();

	public void onApproaching() {

	}

	public void onArrived() {

	}

}
