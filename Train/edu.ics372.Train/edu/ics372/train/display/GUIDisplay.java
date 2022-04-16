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
 */

public class GUIDisplay extends Application implements TrainDisplay {

	private StationReachingButton stationReachingButton;
	private StationReachedButton stationReachedButton;
	private DoorObstructingButton doorObstructingButton;

	private TextField statusField = new TextField();
	private TextField timeField = new TextField();

	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();

		pane.setHgap(2);
		pane.setVgap(2);
		pane.setPadding(new Insets(10, 10, 10, 10));

		// message section
		statusField.setEditable(false);
		timeField.setEditable(false);
		statusField.setPrefSize(200, 5);
		timeField.setPrefSize(200, 5);
		pane.add(statusField, 1, 0);
		pane.add(timeField, 7, 0);

		// passenger mode section
		stationReachingButton = new StationReachingButton("station reaching");
		stationReachedButton = new StationReachedButton("station reached");
		doorObstructingButton = new DoorObstructingButton("door obstructing");

		// pane.add(new Label(" "), 4, 0);
		pane.add(stationReachingButton, 13, 0);
		pane.add(stationReachedButton, 14, 0);
		pane.add(doorObstructingButton, 15, 0);

		stationReachingButton.setPrefSize(125, 5);
		stationReachedButton.setPrefSize(125, 5);
		doorObstructingButton.setPrefSize(125, 5);

		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		primaryStage.setHeight(200);
		primaryStage.setWidth(800);
		TrainContext.instance().setDisplay(this);
		TrainContext.instance().initialize();
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
	public void showTimeLeftMessage(String message) {
		timeField.setText(message);

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

}
