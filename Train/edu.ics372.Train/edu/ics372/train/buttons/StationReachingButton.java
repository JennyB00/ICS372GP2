package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * Button class for Station Reaching event. It implements the handle method.
 * 
 * @author Arun Markandu
 */
public class StationReachingButton extends GUIButton {

	/**
	 * Constructs a new button with the proper label
	 */
	public StationReachingButton() {
		super("Station Approaching");
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().onApproaching();
	}

}
