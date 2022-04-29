package edu.ics372.train.states.doors;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

/**
 * Represents the door closed state
 * 
 * @author Jennifer Bruno
 *
 */
public class DoorClosedState extends DoorState {
	private static DoorClosedState instance;

	/**
	 * Private constructor for singleton
	 */
	private DoorClosedState() {
		instance = this;
	}

	/**
	 * Singleton instance
	 * 
	 * @return The single DoorClosedState instance
	 */
	public static DoorClosedState instance() {
		if (instance == null) {
			instance = new DoorClosedState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 3);
		TrainContext.instance().showDoorClosed();
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
		TrainContext.instance().onStartTransport();
	}
}
