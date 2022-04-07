package edu.ics372.train.display;



import edu.ics372.train.buttons.AccelarateButton;
import edu.ics372.train.buttons.CloseButton;
import edu.ics372.train.buttons.DeaccelerateButton;
import edu.ics372.train.buttons.OpenButton;
import edu.ics372.train.buttons.ReopenButton;
import edu.ics372.train.states.TrainContext;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
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

	private OpenButton openButton;
	private CloseButton closeButton;
	private ReopenButton reopenButton;
	private AccelarateButton accelerateButton;
	private DeaccelerateButton deaccelerateButton;
	
	private Label label = new Label("Open");
	private Label timeLabel = new Label("10");
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		GridPane pane = new GridPane();
		
		pane.setHgap(10);
		pane.setVgap(10);
		pane.setPadding(new Insets(10, 10, 10, 10));
		
		//message section
		pane.add(new Label("Status:"), 0, 0);
		pane.add(label, 1, 0);
		label.setTextFill(Color.GREEN);
		label.setStyle("-fx-font-size: 14px");
		pane.add(new Label("Time left:"), 2, 0);
		pane.add(timeLabel, 3, 0);
		timeLabel.setTextFill(Color.GREEN);
		timeLabel.setStyle("-fx-font-size: 14px");
		
		//passenger mode section
		openButton = new OpenButton("Open");
		closeButton = new CloseButton("Close");
		reopenButton = new ReopenButton("Re-open");
		
		pane.add(new Label("Passenger mode"), 0, 1);
		pane.add(openButton, 0, 2);
		pane.add(closeButton, 0, 3);
		pane.add(reopenButton, 0, 4);

		openButton.setPrefSize(100, 5);
		closeButton.setPrefSize(100, 5);
		reopenButton.setPrefSize(100, 5);
		
		//Running mode
		accelerateButton = new AccelarateButton("Accelerate");
		deaccelerateButton = new DeaccelerateButton("Deaccelerate");
		pane.add(new Label("Running mode"), 2, 1);
		pane.add(accelerateButton, 2, 2);
		pane.add(deaccelerateButton, 2, 3);

		accelerateButton.setPrefSize(100, 5);
		deaccelerateButton.setPrefSize(100, 5);
		
		Scene scene = new Scene(pane);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Train");
		primaryStage.setHeight(400);
		primaryStage.setWidth(400);
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
	public void setStatusMessage(String message) {
		label.setText(message);	
	}
	
	@Override
	public void showAccelerating() {
		label.setText("Train accelerating");		
	}

	@Override
	public void showDeaccelerating() {
		label.setText("Train deaccelerating");		
	}

	@Override
	public void showDoorOpening() {
		label.setText("Door opening");		
	}

	@Override
	public void showDoorClosing() {
		label.setText("Door closing");		
	}

	@Override
	public void showDoorReopening() {
		label.setText("Door reopening");	
	}

	@Override
	public void showTimeLeft(int time) {
		String message = String.valueOf(time);
		timeLabel.setText(message);		
	}
}
