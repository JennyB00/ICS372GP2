package edu.ics372.train.states;

import edu.ics372.train.states.doors.DoorOpeningState;
import edu.ics372.train.states.doors.DoorState;

/**
 * @author Jennifer Bruno
 *
 */
public class PassengerExchangeState extends TrainState {
	private static PassengerExchangeState state;
	private DoorState currentState;

	/**
	 * 
	 */
	private PassengerExchangeState() {

	}

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

	public void changeState(DoorState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}
}
