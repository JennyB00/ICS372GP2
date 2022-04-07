package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class ReopenButton extends GUIButton{

	public ReopenButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().showDoorReopening();
		TrainContext.instance().showTimeLeft(0);
	}

}
