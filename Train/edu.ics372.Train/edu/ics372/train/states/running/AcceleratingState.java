package edu.ics372.train.states.running;

import edu.ics372.train.states.TrainContext;
import edu.ics372.train.states.TransportState;
import edu.ics372.train.timer.Notifiable;
import edu.ics372.train.timer.Timer;

/**
 * This class extends RunningState and implements Notifiable. This state will
 * accelerate the train either for 6 seconds or when an approaching signal is
 * sent
 * 
 * @author Jennifer Bruno
 *
 */
public class AcceleratingState extends RunningState implements Notifiable {
	private static AcceleratingState instance;
	private Timer timer;

	/**
	 * Private constructor for singleton pattern
	 */
	private AcceleratingState() {

	}

	/**
	 * Singleton instance
	 * 
	 * @return The AcceleratingState instance
	 */
	public static AcceleratingState instance() {
		if (instance == null) {
			instance = new AcceleratingState();
		}
		return instance;
	}

	@Override
	public void enter() {
		timer = new Timer(this, 6);
		TrainContext.instance().showAccelerating();
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
		TransportState.instance().changeState(CruisingState.instance());
	}

	@Override
	public void onApproaching() {
		TransportState.instance().changeState(DeceleratingState.instance());
	}

}
