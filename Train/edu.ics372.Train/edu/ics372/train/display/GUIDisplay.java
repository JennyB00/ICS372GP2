package edu.ics372.train.display;

import edu.ics372.train.buttons.DoorObstructingButton;
import edu.ics372.train.buttons.StationReachedButton;
import edu.ics372.train.buttons.StationReachingButton;
import edu.ics372.train.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * @author Arun Markandu
 * 
 *         This class implements APIs that was declared in the Train Display
 *         interface. This is the concrete implementation of user interface
 *         using Java FLEX libraries.
 */

public class GUIDisplay extends Application implements TrainDisplay {

	// Constant messages for the time left display
	private final String TIMELEFT_ACCELERATING_MSG = "seconds until constant speed";
	private final String TIMELEFT_CRUISING_MSG = "waiting for approaching signal";
	private final String TIMELEFT_DECELERATING_MSG = "waiting for arrived signal";
	private final String TIMELEFT_ARRIVED_MSG = "second before opening door";
	private final String TIMELEFT_DOOROPENING_MSG = "seconds until door open";
	private final String TIMELEFT_DOOROPEN_MSG = "seconds until door closes";
	private final String TIMELEFT_DOOROBSTRUCTION_MSG = "seconds until door re-open";
	private final String TIMELEFT_DOORCLOSING_MSG = "seconds until door fully closed";
	private final String TIMELEFT_DOORCLOSED_MSG = "seconds until leaving station";
	private String timerDetails = "";

	private StationReachingButton stationReachingButton; // Button for Station Reaching event
	private StationReachedButton stationReachedButton; // Button for Station Reached event
	private DoorObstructingButton doorObstructingButton; // Button for Door Obstructing event

	private TextField statusField = new TextField(); // Message area for Status messages
	private TextField timeField = new TextField(); // Message area for showing time left messages

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();

		pane.setHgap(2);
		pane.setVgap(2);
		pane.setPadding(new Insets(10, 10, 10, 10));

		// fields for the display messages
		statusField.setEditable(false);
		timeField.setEditable(false);
		statusField.setPrefSize(200, 5);
		timeField.setPrefSize(225, 5);
		pane.add(statusField, 1, 0);
		pane.add(timeField, 7, 0);

		// buttons
		stationReachingButton = new StationReachingButton();
		stationReachedButton = new StationReachedButton();
		doorObstructingButton = new DoorObstructingButton();

		// Place the button on the grid
		pane.add(stationReachingButton, 13, 0);
		pane.add(stationReachedButton, 14, 0);
		pane.add(doorObstructingButton, 15, 0);

		// set the preferred sizes for the button
		stationReachingButton.setPrefSize(125, 5);
		stationReachedButton.setPrefSize(125, 5);
		doorObstructingButton.setPrefSize(125, 5);

		// Set the stage size and title
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		primaryStage.setHeight(200);
		primaryStage.setWidth(900);

		TrainContext.instance().setDisplay(this); // This will set the display object to the TrainContext
		TrainContext.instance().initialize(); // Initialize the TrainContext

		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	@Override
	public void showTimeLeft(int time) {
		String message = String.valueOf(time) + " " + timerDetails;
		timeField.setText(message);
	}

	@Override
	public void showAccelerating() {
		statusField.setText("Accelerating");
		timerDetails = TIMELEFT_ACCELERATING_MSG;
	}

	@Override
	public void showConstantSpeed() {
		statusField.setText("Constant Speed");
		timeField.setText(TIMELEFT_CRUISING_MSG);
	}

	@Override
	public void showDecelerating() {
		statusField.setText("Deaccelerating");
		timeField.setText(TIMELEFT_DECELERATING_MSG);
	}

	@Override
	public void showArrived() {
		statusField.setText("Arrived @ Station");
		timerDetails = TIMELEFT_ARRIVED_MSG;
	}

	@Override
	public void showDoorOpening() {
		statusField.setText("Door Opening");
		timerDetails = TIMELEFT_DOOROPENING_MSG;
	}

	@Override
	public void showDoorOpen() {
		statusField.setText("Door Open");
		timerDetails = TIMELEFT_DOOROPEN_MSG;
	}

	@Override
	public void showDoorClosing() {
		statusField.setText("Door Closing:Watch Out");
		timerDetails = TIMELEFT_DOORCLOSING_MSG;
	}

	@Override
	public void showDoorReOpening() {
		statusField.setText("Door Reopening");
		timerDetails = TIMELEFT_DOOROBSTRUCTION_MSG;
	}

	@Override
	public void showDoorClosed() {
		statusField.setText("Door Closed");
		timerDetails = TIMELEFT_DOORCLOSED_MSG;
	}

	@Override
	public void setStatusMessage(String message) {
		statusField.setText(message);
	}
}
