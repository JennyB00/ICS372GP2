package edu.ics372.train.states.running;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.states.TransportState;

/**
 * @author Jennifer Bruno
 *
 */
public class CruisingState extends RunningState {
	private static CruisingState instance;

	/**
	 * Private constructor for singleton pattern
	 */
	private CruisingState() {

	}

	/**
	 * Singleton instance
	 * 
	 * @return The CruisingState instance
	 */
	public static CruisingState instance() {
		if (instance == null) {
			instance = new CruisingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		TrainContext.instance().showCruising();
	}

	@Override
	public void leave() {

	}

	@Override
	public void onApproaching() {
		TransportState.instance().changeState(DeceleratingState.instance());
	}

}
