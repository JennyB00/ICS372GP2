package edu.ics372.train.states;

import edu.ics372.train.states.running.RunningContext;

/**
 * @author Jennifer Bruno
 *
 */
public class TransportState extends TrainState {
	private static TransportState state;

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
		RunningContext.instance().initialize();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExchangePassengers() {
		TrainContext.instance().changeState(PassengerExchangeState.instance());
	}

}
