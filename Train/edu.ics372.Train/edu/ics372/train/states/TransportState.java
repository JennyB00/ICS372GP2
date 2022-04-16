package edu.ics372.train.states;

import edu.ics372.train.states.running.AcceleratingState;
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

	public void changeState(RunningState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

}
