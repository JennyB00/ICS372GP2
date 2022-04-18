package edu.ics372.train.buttons;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

/**
 * 
 * @author Arun Markandu
 *
 */
public abstract class GUIButton extends Button implements EventHandler<ActionEvent> {
	
	public GUIButton(String string) {
		super(string);
		setOnAction(this);
	}

}