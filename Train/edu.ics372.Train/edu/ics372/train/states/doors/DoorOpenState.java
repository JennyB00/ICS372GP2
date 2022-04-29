package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

/**
 * Represents the door open state
 * 
 * @author Jennifer Bruno
 *
 */
public class DoorOpenState extends DoorState {
	private static DoorOpenState instance;

	/**
	 * Private constructor for singleton
	 */
	private DoorOpenState() {
		instance = this;
	}

	/**
	 * Singleton instance
	 * 
	 * @return The single DoorOpenState instance
	 */
	public static DoorOpenState instance() {
		if (instance == null) {
			instance = new DoorOpenState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 30);
		TrainContext.instance().showDoorOpen();
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
		PassengerExchangeState.instance().changeState(DoorClosingState.instance());
	}

}
