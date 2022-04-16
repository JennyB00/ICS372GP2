package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class DoorObstructingButton extends GUIButton {

	public DoorObstructingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
//		TrainContext.instance().showDoorReopening();
//		TrainContext.instance().showTimeLeft(3);
		TrainContext.instance().onObstruction();
	}

}
