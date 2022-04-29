package edu.ics372.train.states;

/**
 * This is the superclass for all super states
 * 
 * @author Jennifer Bruno
 *
 */
public abstract class TrainState extends State {
	/**
	 * Process a start passenger exchange event
	 */
	public void onExchangePassengers() {

	}

	/**
	 * Process a start transportation event
	 */
	public void onStartTransport() {

	}

	/**
	 * Process an approaching signal
	 */
	public void onApproaching() {

	}

	/**
	 * Process an arrived signal
	 */
	public void onArrived() {

	}

	/**
	 * Process a door obstruction signal
	 */
	public void onObstruction() {

	}
}
