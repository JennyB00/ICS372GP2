package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

public class DoorReOpenState extends DoorState {
	private static DoorReOpenState instance;

	/**
	 * 
	 */
	private DoorReOpenState() {
		instance = this;
	}

	/**
	 * 
	 * 
	 * @return the object
	 */
	public static DoorReOpenState instance() {
		if (instance == null) {
			instance = new DoorReOpenState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 8);
		TrainContext.instance().showDoorOpen();
		//TrainContext.instance().showTimeLeft(timer.getTimeValue());
		TrainContext.instance().showTimeLeftDoorReOpening(timer.getTimeValue());
	}

	@Override
	public void leave() {
		timer.stop();
		timer = null;
		TrainContext.instance().showTimeLeft(0);
	}

	@Override
	public void onTimerTick(int timerValue) {
		//TrainContext.instance().showTimeLeft(timerValue);
		TrainContext.instance().showTimeLeftDoorReOpening(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		TrainContext.instance().showTimeLeft(0);
		PassengerExchangeState.instance().changeState(DoorClosingState.instance());
	}

}
