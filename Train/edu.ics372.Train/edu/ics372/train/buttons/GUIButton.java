package edu.ics372.train.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * This is the abstract class for all the buttons on the UI
 * 
 * @author Arun Markandu
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {

	/**
	 * Constructs a new button with the given label
	 * 
	 * @param string The button label
	 */
	public GUIButton(String string) {
		super(string);
		setOnAction(this); // Tie the event handler to this button object
	}

}