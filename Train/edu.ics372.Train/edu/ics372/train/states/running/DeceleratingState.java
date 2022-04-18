package edu.ics372.train.states.running;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.states.TransportState;

/**
 * @author Jennifer Bruno
 *
 */
public class DeceleratingState extends RunningState {
	private static DeceleratingState instance;

	/**
	 * Private constructor for singleton pattern
	 */
	private DeceleratingState() {

	}

	/**
	 * Singleton instance
	 * 
	 * @return The DeceleratingState instance
	 */
	public static DeceleratingState instance() {
		if (instance == null) {
			instance = new DeceleratingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		TrainContext.instance().showDeaccelerating();
	}

	@Override
	public void leave() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onArrived() {
		TransportState.instance().changeState(StoppedState.instance());
	}

}
