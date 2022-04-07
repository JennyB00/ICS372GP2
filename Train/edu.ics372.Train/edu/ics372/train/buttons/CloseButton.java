package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu 
 *
 */
public class CloseButton extends GUIButton{

	public CloseButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().showDoorClosing();
		TrainContext.instance().showTimeLeft(0);
		
	}
}
