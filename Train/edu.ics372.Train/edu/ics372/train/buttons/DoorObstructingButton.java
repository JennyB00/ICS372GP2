package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * Button class for Door Obstructing event. It implements the handle method.
 * 
 * @author Arun Markandu
 */
public class DoorObstructingButton extends GUIButton {

	/**
	 * Constructs a new button with the proper label
	 */
	public DoorObstructingButton() {
		super("Door Obstruction");
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().onObstruction();
	}

}
