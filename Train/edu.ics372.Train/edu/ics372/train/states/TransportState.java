package edu.ics372.train.states;

import edu.ics372.train.states.running.AcceleratingState;
import edu.ics372.train.states.running.RunningState;

/**
 * Represents the transport state
 * 
 * @author Jennifer Bruno
 *
 */
public class TransportState extends TrainState {
	private static TransportState state;
	private RunningState currentState;

	/**
	 * private constructor for singleton pattern
	 */
	private TransportState() {
	}

	/**
	 * singleton instance
	 * 
	 * @return the single TransportState
	 */
	public static TransportState instance() {
		if (state == null) {
			state = new TransportState();
		}
		return state;
	}

	@Override
	public void enter() {
		currentState = AcceleratingState.instance();
		currentState.enter();
	}

	@Override
	public void leave() {
		currentState.leave();
		currentState = null;
	}

	@Override
	public void onExchangePassengers() {
		TrainContext.instance().changeState(PassengerExchangeState.instance());
	}

	@Override
	public void onApproaching() {
		currentState.onApproaching();
	}

	@Override
	public void onArrived() {
		currentState.onArrived();
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState The next state
	 */
	public void changeState(RunningState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

}
