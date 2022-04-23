package edu.ics372.train.states;

import edu.ics372.train.display.TrainDisplay;

/**
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

	public void initialize() {
		currentState = TransportState.instance();
		currentState.enter();
	}

	/**
	 * 
	 * @param nextState
	 */
	public void changeState(TrainState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void onExchangePassengers() {
		currentState.onExchangePassengers();
	}

	public void onStartTransport() {
		currentState.onStartTransport();
	}

	public void onApproaching() {
		currentState.onApproaching();
	}

	public void onArrived() {
		currentState.onArrived();
	}

	public void onObstruction() {
		currentState.onObstruction();
	}

	public TrainDisplay getDisplay() {
		return display;
	}

	public void setDisplay(TrainDisplay display) {
		this.display = display;
	}

	public TrainState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(TrainState currentState) {
		this.currentState = currentState;
	}

	public void showDoorOpening() {
		display.showDoorOpening();
	}

	public void showDoorOpen() {
		display.showDoorOpen();
	}

	public void showDoorClosing() {
		display.showDoorClosing();
	}

	public void showDoorObstruciton() {
		display.showDoorObstruction();
	}

	public void showDoorClosed() {
		display.showDoorClosed();
	}

	public void showAccelerating() {
		display.showAccelerating();
	}

	public void showDeaccelerating() {
		display.showDecelerating();
	}

	public void showCruising() {
		display.showConstantSpeed();
	}

	public void showArrived() {
		display.showArrived();
	}

	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}
	
	public void showTimeLeftDoorOpening(int time) {
		display.showTimeLeftDoorOpening(time);
	}
	
	public void showTimeLeftDoorReOpening(int time) {
		display.showTimeLeftDoorReOpening(time);
	}
	
	public void showTimeLeftDoorClosing(int time) {
		display.showTimeLeftDoorClosing(time);
	}
	
	public void showTimeLeftApproaching(int time) {
		display.showTimeLeftApproaching(time);
	}
	
	public void showTimeLeftDoorAccelerating(int time) {
		display.showTimeLeftAccelerating(time);
	}
	
	public void showTimeLeftDecelerating(int time) {
		display.showTimeLeftDecelerating(time);
	}
}
