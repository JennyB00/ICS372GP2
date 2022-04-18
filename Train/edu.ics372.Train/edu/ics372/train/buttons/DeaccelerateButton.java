package edu.ics372.train.buttons;

import edu.ics372.train.states.TrainContext;
import javafx.event.ActionEvent;

/**
 * 
 * @author Arun Markandu
 *
 */
public class DeaccelerateButton extends GUIButton{

	public DeaccelerateButton(String string) {
		super(string);
	}

	@Override
	public void handle(ActionEvent event) {
		//TrainContext.instance().showDeaccelerating();;
		//TrainContext.instance().showTimeLeftMessage("0");
		
	}

}
