package org.moogirc.jbomberman;

import javax.swing.*;
import java.awt.*;


/**
 * The class that manages all the screen activities. Examples are setting the resulution,
 * setting full screen, returning to normal mode, and so on.
 *
 * @author Mathias Bjerke
 */
public class ScreenManager {
	private GraphicsEnvironment environment;
	private GraphicsDevice device;
	private JFrame window;


	/**
	 * Default constructor which gets the local graphics environment and
	 * default screen device
	 */
	public ScreenManager() {
		environment = GraphicsEnvironment.getLocalGraphicsEnvironment();
		device = environment.getDefaultScreenDevice();
		window = new JFrame();
	}


	/**
	 * Get all the compatible display modes on the system
	 * @return an array of compatible display modes
	 */
	public DisplayMode[] getCompatibleDisplayModes() {
		return device.getDisplayModes();
	}


	/**
	 * Get the current display mode
	 * @return the current display mode
	 */
	public DisplayMode getCurrentDisplayMode() {
		return device.getDisplayMode();
	}


	/**
	 * Set the window in full screen
	 * @param displayMode which displaymode to set the window
	 */
	public void setFullScreen( DisplayMode displayMode ) {
		window.dispose();
		window.setUndecorated( true );
		window.setResizable( false );
		
		device.setFullScreenWindow( window );
		if( displayMode != null && device.isDisplayChangeSupported() ) {
			try {
				device.setDisplayMode(displayMode);				
			} catch (IllegalArgumentException ex) {
				// ignore - illegal mode for this device
			}
		}
        window.setVisible(true);
	}


	/**
	 * Restore the regular windowed screen
	 */
	public void restoreScreen() {
		Window window = device.getFullScreenWindow();

		if( window != null ) {
			window.dispose();
		}

		device.setFullScreenWindow( null );
	}


	/**
	 * Get the window object
	 * @return JFrame
	 */
	public JFrame getWindow() {
		return window;
	}
}
