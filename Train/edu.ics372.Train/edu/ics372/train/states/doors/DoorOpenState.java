package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

public class DoorOpenState extends DoorState {
	private static DoorOpenState instance;

	/**
	 * 
	 */
	private DoorOpenState() {
		instance = this;
	}

	/**
	 * 
	 * 
	 * @return the object
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
		// TODO show door open
		TrainContext.instance().showTimeLeft(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.instance().showTimeLeft(0);
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
