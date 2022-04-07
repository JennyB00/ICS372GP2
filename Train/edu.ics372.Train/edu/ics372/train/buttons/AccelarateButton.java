package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class AccelarateButton extends GUIButton{

	public AccelarateButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().showAccelerating();
		TrainContext.instance().showTimeLeft(0);
		
	}

}
