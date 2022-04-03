package edu.ics372.train.states;

/**
 * @author Jennifer Bruno
 *
 */
public class TrainContext {
	private static TrainContext train;
	private TrainState currentState;

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
	 * Initializes the train context to the start state, start moving first
	 */
	public void initialize() {

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
}
