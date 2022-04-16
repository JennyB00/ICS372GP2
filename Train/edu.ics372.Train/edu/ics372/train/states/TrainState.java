package edu.ics372.train.states;

/**
 * @author Jennifer Bruno
 *
 */
public abstract class TrainState {
	/**
	 * 
	 */
	public abstract void enter();

	/**
	 * 
	 */
	public abstract void leave();

	public void onExchangePassengers() {

	}

	public void onStartTransport() {

	}

	public void onApproaching() {

	}

	public void onArrived() {

	}

	public void onObstruction() {

	}
}
