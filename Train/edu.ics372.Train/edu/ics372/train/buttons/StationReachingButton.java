package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class StationReachingButton extends GUIButton{

	public StationReachingButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		TrainContext.instance().showDoorOpening();
		TrainContext.instance().showTimeLeft(7);
		
	}

}
