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
 * This class implements APIs that was declared in the Train Display interface.
 * This is the concrete implementation of user interface using Java FLEX libraries.
 */

public class GUIDisplay extends Application implements TrainDisplay {
	
	//Constant messages for the time left display
	private final String TIMELEFT_ACCELERATING_MSG = "seconds left before constant speed";
	private final String TIMELEFT_DEACCELERATING_MSG = "seconds left before stopping";
	private final String TIMELEFT_DOOROPENING_MSG = "seconds left before opening";
	private final String TIMELEFT_REDOOROPENING_MSG = "seconds left befor reopening";
	private final String TIMELEFT_DOORCLOSING_MSG = "seconds left before closing";
	private final String TIMELEFT_APPROACHING_MSG = "seconds left before aproaching";

	private StationReachingButton stationReachingButton; //Button for Station Reaching event
	private StationReachedButton stationReachedButton; //Button for Station Reached event
	private DoorObstructingButton doorObstructingButton; //Button for Door Obstructing event

	private TextField statusField = new TextField(); //Message area for Status messages
	private TextField timeField = new TextField(); //Message area for showing time left messages

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

		//buttons
		stationReachingButton = new StationReachingButton("station reaching");
		stationReachedButton = new StationReachedButton("station reached");
		doorObstructingButton = new DoorObstructingButton("door obstructing");

		//Place the button on the grid
		pane.add(stationReachingButton, 13, 0);
		pane.add(stationReachedButton, 14, 0);
		pane.add(doorObstructingButton, 15, 0);

		//set the preferred sizes for the button
		stationReachingButton.setPrefSize(125, 5);
		stationReachedButton.setPrefSize(125, 5);
		doorObstructingButton.setPrefSize(125, 5);

		//Set the stage size and title
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		primaryStage.setHeight(200);
		primaryStage.setWidth(800);
		
		TrainContext.instance().setDisplay(this); //This will set the display object to the TrainContext
		TrainContext.instance().initialize(); //Initialize the TrainContext
		
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});
	}

	@Override
	public void showApproaching() {
		statusField.setText("Approaching Station");
	}

	@Override
	public void showDoorObstruction() {
		statusField.setText("Door Obstruction!:Reopening");
	}

	@Override
	public void showArrived() {
		statusField.setText("Arrived @ Station");
	}

	@Override
	public void showTimeLeft(int time) {
		String message = String.valueOf(time);
		timeField.setText(message);
	}

	@Override
	public void setStatusMessage(String message) {
		statusField.setText(message);
	}

	@Override
	public void showAccelerating() {
		statusField.setText("Accelerating");
	}

	@Override
	public void showDecelerating() {
		statusField.setText("Deaccelerating");
	}

	@Override
	public void showConstantSpeed() {
		statusField.setText("Constant Speed");
	}

	@Override
	public void showDoorClosing() {
		statusField.setText("Door Closing:Watch Out");
	}

	@Override
	public void showDoorClosed() {
		statusField.setText("Door Closed");
	}

	@Override
	public void showDoorOpening() {
		statusField.setText("Door Opening");
	}

	@Override
	public void showDoorOpen() {
		statusField.setText("Door Open");
	}

	@Override
	public void showTimeLeftDoorOpening(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_DOOROPENING_MSG;
		timeField.setText(message);	
	}

	@Override
	public void showTimeLeftDoorReOpening(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_REDOOROPENING_MSG;
		timeField.setText(message);	
	}

	@Override
	public void showTimeLeftDoorClosing(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_DOORCLOSING_MSG;
		timeField.setText(message);	
	}

	@Override
	public void showTimeLeftApproaching(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_APPROACHING_MSG;
		timeField.setText(message);
		
	}

	@Override
	public void showTimeLeftAccelerating(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_ACCELERATING_MSG;
		timeField.setText(message);	
	}

	@Override
	public void showTimeLeftDecelerating(int time) {
		String message = String.valueOf(time);
		message = message + " " + TIMELEFT_DEACCELERATING_MSG;
		timeField.setText(message);
	}
}
