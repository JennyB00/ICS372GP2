package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * Button class for Station Reached event. It implements the handle method.
 * 
 * @author Arun Markandu
 * 
 * 
 */
public class StationReachedButton extends GUIButton {

	/**
	 * Constructs a new button with the proper label
	 */
	public StationReachedButton() {
		super("Station Arrived");
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().onArrived();
	}
}
