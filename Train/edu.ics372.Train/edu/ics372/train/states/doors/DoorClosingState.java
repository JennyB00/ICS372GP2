package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

/**
 * Represents the door closing state, listens for obstructions while closing
 * 
 * @author Jennifer Bruno
 *
 */
public class DoorClosingState extends DoorState {
	private static DoorClosingState instance;

	/**
	 * Private constructor for singleton
	 */
	private DoorClosingState() {
		instance = this;
	}

	/**
	 * Singleton instance
	 * 
	 * @return The single DoorClosingState instance
	 */
	public static DoorClosingState instance() {
		if (instance == null) {
			instance = new DoorClosingState();
		}
		return instance;
	}

	@Override
	public void onObstruction() {
		DoorReOpeningState.setObstructionTime(5 - timer.getTimeValue());
		PassengerExchangeState.instance().changeState(DoorReOpeningState.instance());
	}

	@Override
	public void enter() {
		timer = new Timer(this, 5);
		TrainContext.instance().showDoorClosing();
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
		PassengerExchangeState.instance().changeState(DoorClosedState.instance());
	}

}
