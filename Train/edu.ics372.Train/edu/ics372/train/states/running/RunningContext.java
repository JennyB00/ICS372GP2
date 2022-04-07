package edu.ics372.train.states.running;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.states.TransportState;

/**
 * @author Jennifer Bruno
 *
 */
public class RunningContext {
	private static RunningContext running;
	private RunningState currentState;

	private RunningContext() {

	}

	/**
	 * 
	 * @return
	 */
	public static RunningContext instance() {
		if (running == null) {
			running = new RunningContext();
		}
		return running;
	}

	public void initialize() {
		// current = accelerating
	//	currentState.enter(); //commented out for now, throwing null
	}

	public void changeState(RunningState nextState) {
		currentState.leave();
		currentState = nextState;
		currentState.enter();
	}

	public void onExchangePassengers() {
		TrainContext.instance().onExchangePassengers();
	}

	public void onApproaching() {
		currentState.onApproaching();
	}

}
