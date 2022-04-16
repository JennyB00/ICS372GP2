package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

public class DoorReOpeningState extends DoorState {
	private static DoorReOpeningState instance;
	private static int obstructionTime;

	private DoorReOpeningState() {
		instance = this;
	}

	public static DoorReOpeningState instance() {
		if (instance == null) {
			instance = new DoorReOpeningState();
		}
		return instance;
	}

	/**
	 * Sets the obstruction time IMPORTANT: Must be called before entering this
	 * state
	 * 
	 * @param sec The time of the obstruction event
	 */
	public static void setObstructionTime(int sec) {
		obstructionTime = sec;
	}

	@Override
	public void enter() {
		timer = new Timer(this, obstructionTime * 4 / 5);
		TrainContext.instance().showDoorObstruciton();
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
		PassengerExchangeState.instance().changeState(DoorReOpenState.instance());
	}
}
