package edu.ics372.train.states.doors;

import edu.ics372.train.states.TrainContext;

/**
 * @author Jennifer Bruno
 *
 */
public class DoorContext {
	private static DoorContext doors;
	private DoorState currentState;

	/**
	 * Private constructor for singleton pattern
	 */
	private DoorContext() {

	}

	/**
	 * 
	 * @return
	 */
	public static DoorContext instance() {
		if (doors == null) {
			doors = new DoorContext();
		}
		return doors;
	}

	/**
	 * 
	 */
	public void initialize() {
		// current = opening
		currentState.enter();
	}

	public void changeState(DoorState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void onStartTransport() {
		TrainContext.instance().onStartTransport();
	}
}
