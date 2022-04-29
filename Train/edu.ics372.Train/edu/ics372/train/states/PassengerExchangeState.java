package edu.ics372.train.states;

import edu.ics372.train.states.doors.DoorOpeningState;
import edu.ics372.train.states.doors.DoorState;

/**
 * Represents the Passenger Exchange State
 * 
 * @author Jennifer Bruno
 */
public class PassengerExchangeState extends TrainState {
	private static PassengerExchangeState state;
	private DoorState currentState;

	/**
	 * private constructor for singleton pattern
	 */
	private PassengerExchangeState() {

	}

	/**
	 * singleton instance
	 * 
	 * @return the single PassengerExchangeState
	 */
	public static PassengerExchangeState instance() {
		if (state == null) {
			state = new PassengerExchangeState();
		}
		return state;
	}

	@Override
	public void enter() {// There needs to be an initial state for machine to work
		currentState = DoorOpeningState.instance();
		currentState.enter();
	}

	@Override
	public void leave() {
		currentState.leave();
		currentState = null;
	}

	@Override
	public void onStartTransport() {
		TrainContext.instance().changeState(TransportState.instance());
	}

	@Override
	public void onObstruction() {
		currentState.onObstruction();
	}

	/**
	 * Called from the states to change the current state
	 * 
	 * @param nextState The next state
	 */
	public void changeState(DoorState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}
}
