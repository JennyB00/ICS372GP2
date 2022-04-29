package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

/**
 * Represents the door opening state
 * 
 * @author Jennifer Bruno
 *
 */
public class DoorOpeningState extends DoorState {
	private static DoorOpeningState instance;

	/**
	 * Private constructor for singleton
	 */
	private DoorOpeningState() {
		instance = this;
	}

	/**
	 * Singleton instance
	 * 
	 * @return The single DoorOpeningState instance
	 */
	public static DoorOpeningState instance() {
		if (instance == null) {
			instance = new DoorOpeningState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 4);
		TrainContext.instance().showDoorOpening();
		TrainContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
	}

	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.instance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.instance().showTimeLeft(0);
		PassengerExchangeState.instance().changeState(DoorOpenState.instance());
	}
}
