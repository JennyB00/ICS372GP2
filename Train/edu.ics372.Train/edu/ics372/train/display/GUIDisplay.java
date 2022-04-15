package edu.ics372.train.display;



import edu.ics372.train.buttons.AccelarateButton;
import edu.ics372.train.buttons.StationReachedButton;
import edu.ics372.train.buttons.DeaccelerateButton;
import edu.ics372.train.buttons.StationReachingButton;
import edu.ics372.train.buttons.DoorObstructingButton;
import edu.ics372.train.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * 
 * @author Arun Markandu
 *
 */

public class GUIDisplay extends Application implements TrainDisplay{

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
		
		//message section
		//statusField.setEditable(false);
		//timeField.setEditable(false);
		statusField.setPrefSize(200, 5);
		timeField.setPrefSize(200, 5);
		pane.add(statusField, 1, 0);
		pane.add(timeField, 7, 0);
		
		//passenger mode section
		stationReachingButton = new StationReachingButton("station reaching");
		stationReachedButton = new StationReachedButton("station reached");
		doorObstructingButton = new DoorObstructingButton("door obstructing");
		
		//pane.add(new Label(" "), 4, 0);
		pane.add(stationReachingButton, 13, 0);
		pane.add(stationReachedButton, 14, 0);
		pane.add(doorObstructingButton, 15, 0);

		//stationReachingButton .setPrefSize(100, 5);
		//stationReachedButton.setPrefSize(100, 5);
		//doorObstructingButton.setPrefSize(100, 5);
		
		//Running mode

		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		primaryStage.setHeight(200);
		primaryStage.setWidth(800);
		TrainContext.instance().setDisplay(this);
		primaryStage.show();
		primaryStage.addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent window) {
				System.exit(0);
			}
		});	
	}

	@Override
	public void showStationReachingButton() {
		statusField.setText("Station reaching");	

	}

	@Override
	public void showDoorObstructingButton() {
		statusField.setText("Door obstructing");

	}

	@Override
	public void showStationReachedButton() {
		statusField.setText("Station reached");	

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
		statusField.setText("accelerating");
		
	}

	@Override
	public void showDecelerating() {
		statusField.setText("deaccelerating");
		
	}
}
