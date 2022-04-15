package edu.ics372.train.display;

/**
 * 
 * @author Arun Markandu
 *
 */
public interface TrainDisplay {
	public void setStatusMessage(String message);
	
	
	public void showStationReachingButton();
	
	public void showStationReachedButton();
	
	public void showDoorObstructingButton();
	
	public void showTimeLeft(int time);
	
	public void showAccelerating();
	
	public void showDecelerating();
}
