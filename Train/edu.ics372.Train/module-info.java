module edu.ics372.Train {
	requires javafx.controls;
	requires javafx.base;
	requires java.desktop;

	//
	exports edu.ics372.train.display to javafx.graphics;
	exports edu.ics372.train.start to javafx.graphics;
}