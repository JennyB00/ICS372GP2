package edu.ics372.train.start;

import edu.ics372.train.display.GUIDisplay;
import edu.ics372.train.timer.Clock;
import javafx.application.Application;

/**
 * 
 * @author Arun Markandu
 *
 * This is the main class to invoke the FLEX GUI display
 */
public class Main {
	public static void main(String[] args) {
		Clock.getInstance();
		new Thread() {
			@Override
			public void run() {
				Application.launch(GUIDisplay.class, null);
			}
		}.start();
	}
}
