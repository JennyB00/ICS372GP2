package edu.ics372.train.states;

import edu.ics372.train.states.running.RunningState;

/**
 * @author Jennifer Bruno
 *
 */
public class TransportState extends TrainState {
	private static TransportState state;
	private RunningState currentState;

	/**
	 * 
	 */
	private TransportState() {
	}

	public static TransportState instance() {
		if (state == null) {
			state = new TransportState();
		}
		return state;
	}

	@Override
	public void enter() {
		// current = accelerating
		// currentState.enter();
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

	public void changeState(RunningState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

}
