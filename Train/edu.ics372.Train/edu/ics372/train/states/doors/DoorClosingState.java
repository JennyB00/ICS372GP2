package edu.ics372.train.states.doors;

import edu.ics372.train.states.PassengerExchangeState;
import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Timer;

public class DoorClosingState extends DoorState {
	private static DoorClosingState instance;

	private DoorClosingState() {
		instance = this;
	}

	public static DoorClosingState instance() {
		if (instance == null) {
			instance = new DoorClosingState();
		}
		return instance;
	}

	@Override
	public void onObstruction() {
		DoorReOpeningState.setObstructionTime(timer.getTimeValue());
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
		TrainContext.instance().showTimeLeft(0);
	}

	@Override
	public void onTimerTick(int timerValue) {
		TrainContext.instance().showTimeLeft(timerValue);
	}

	@Override
	public void onTimerRunsOut() {
		PassengerExchangeState.instance().changeState(DoorClosedState.instance());
	}

}
