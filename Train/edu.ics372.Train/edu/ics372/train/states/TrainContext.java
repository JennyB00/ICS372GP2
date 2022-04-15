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
		currentState = TransportState.instance();
		currentState.enter();
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
		display.showStationReachingButton();
	}

	public void showDoorClosing() {
		display.showDoorObstructingButton();
	}

	public void showDoorReopening() {
		display.showStationReachedButton();
	}
	
	public void showAccelerating() {
		display.showAccelerating();
	}
	
	public void showDeaccelerating() {
		display.showDecelerating();
	}


	public void showTimeLeft(int time) {
		display.showTimeLeft(time);
	}
}
