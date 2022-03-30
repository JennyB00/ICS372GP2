package edu.ics372.Train.timer;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 *
 * @author Brahma Dathan and Sarnath Ramnath
 * @Copyright (c) 2010

 * Redistribution and use with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 *   - the use is for academic purpose only
 *   - Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 *   - Neither the name of Brahma Dathan or Sarnath Ramnath
 *     may be used to endorse or promote products derived
 *     from this software without specific prior written permission.
 *
 * The authors do not make any claims regarding the correctness of the code in this module
 * and are not responsible for any loss or damage resulting from its use.
 */

/**
 * Implements a clock as a Runnable. An object adapter that uses
 * PropertyChangeSupport to implement the Observable part of the Observer
 * pattern.
 *
 */
public class Clock implements Runnable {
	private Thread thread = new Thread(this);
	private static Clock clock;
	private final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);

	/**
	 * Adds a listener
	 *
	 * @param listener the listener to be added
	 */
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.addPropertyChangeListener(listener);
	}

	/**
	 * Removes a listener
	 *
	 * @param listener the listener to be removed
	 */
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		this.propertyChangeSupport.removePropertyChangeListener(listener);
	}

	/**
	 * Start the thread
	 */
	private Clock() {
		thread.start();
	}

	/**
	 * To get the instance
	 *
	 * @return returns the clock
	 */
	public static Clock getInstance() {
		if (clock == null) {
			clock = new Clock();
		}
		return clock;
	}

	/**
	 * Infinite loop to generate the clock ticks Notify all users when clock ticks
	 */
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(1000);
				this.propertyChangeSupport.firePropertyChange(null, null, null);

			}
		} catch (InterruptedException ie) {
		}
	}

}
