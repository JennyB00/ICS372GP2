package edu.ics372.train.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * 
 * @author Arun Markandu
 * 
 * This is the abstract class for all the buttons on the UI
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
	
	public GUIButton(String string) {
		super(string);
		setOnAction(this); //Tie the event handler to this button object
	}

}