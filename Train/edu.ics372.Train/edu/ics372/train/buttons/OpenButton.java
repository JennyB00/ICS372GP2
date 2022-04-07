package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class OpenButton extends GUIButton{

	public OpenButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().showDoorOpening();
		TrainContext.instance().showTimeLeft(0);
		
	}

}
