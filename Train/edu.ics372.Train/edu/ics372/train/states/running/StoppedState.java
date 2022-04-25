package edu.ics372.train.states.running;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.timer.Notifiable;
import edu.ics372.train.timer.Timer;

/**
 * @author Jennifer Bruno
 *
 */
public class StoppedState extends RunningState implements Notifiable {
	private static StoppedState instance;
	private Timer timer;

	private StoppedState() {

	}

	public static StoppedState instance() {
		if (instance == null) {
			instance = new StoppedState();
		}
		return instance;
	}

	@Override
	public void enter() {
		TrainContext.instance().showArrived();
		timer = new Timer(this, 1);
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
		TrainContext.instance().onExchangePassengers();
	}

}
