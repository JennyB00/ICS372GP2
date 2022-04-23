package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 * 
 * Button class for Station Reached event.
 * It implements the handle method.
 */
public class StationReachedButton extends GUIButton {

	public StationReachedButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
//		TrainContext.instance().showDoorClosing();
//		TrainContext.instance().showTimeLeft(6);
		TrainContext.instance().onArrived();
	}
}
