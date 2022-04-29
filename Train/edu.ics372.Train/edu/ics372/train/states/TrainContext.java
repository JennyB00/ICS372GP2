package edu.ics372.train.states;

import edu.ics372.train.display.TrainDisplay;

/**
 * The context stores the context info for the states
 * 
 * @author Jennifer Bruno
 *
 */
public class TrainContext {
	private static TrainContext train;
	private TrainState currentState;

	private TrainDisplay display;

	/**
	 * Private constructor for singleton
	 */
	private TrainContext() {
		train = this;

	}

	/**
	 * Singleton instance
	 * 
	 * @return The single TrainContext instance
	 */
	public static TrainContext instance() {
		if (train == null) {
			train = new TrainContext();
		}
		return train;
	}

	/**
	 * Initializes the context to start the first state
	 */
	public void initialize() {
		currentState = TransportState.instance();
		currentState.enter();
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState The next state
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	/**
	 * Process a start passenger exchange event
	 */
	public void onExchangePassengers() {
		currentState.onExchangePassengers();
	}

	/**
	 * Process a start transportation event
	 */
	public void onStartTransport() {
		currentState.onStartTransport();
	}

	/**
	 * Process an approaching signal
	 */
	public void onApproaching() {
		currentState.onApproaching();
	}

	/**
	 * Process an arrived signal
	 */
	public void onArrived() {
		currentState.onArrived();
	}

	/**
	 * Process a door obstruction signal
	 */
	public void onObstruction() {
		currentState.onObstruction();
	}

	/**
	 * Sets the display reference
	 * 
	 * @param display The display object to use
	 */
	public void setDisplay(TrainDisplay display) {
		this.display = display;
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showAccelerating() {
		display.showAccelerating();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showCruising() {
		display.showConstantSpeed();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDeaccelerating() {
		display.showDecelerating();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showArrived() {
		display.showArrived();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDoorOpening() {
		display.showDoorOpening();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDoorOpen() {
		display.showDoorOpen();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDoorClosing() {
		display.showDoorClosing();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDoorObstruciton() {
		display.showDoorReOpening();
	}

	/**
	 * Invokes the right method of the display.
	 */
	public void showDoorClosed() {
		display.showDoorClosed();
	}

	/**
	 * Invokes the right method of the display.
	 * 
	 * @param time timer value
	 */
	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}

}
