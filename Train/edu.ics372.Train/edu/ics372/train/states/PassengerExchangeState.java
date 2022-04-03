package edu.ics372.train.states;

import edu.ics372.train.states.doors.DoorContext;

/**
 * @author Jennifer Bruno
 *
 */
public class PassengerExchangeState extends TrainState {
	private static PassengerExchangeState state;

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
	public void enter() {
		DoorContext.instance().initialize();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onStartTransport() {
		TrainContext.instance().changeState(TransportState.instance());
	}

}
