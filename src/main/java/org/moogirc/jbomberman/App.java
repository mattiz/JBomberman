package org.moogirc.jbomberman;

import javax.swing.*;
import java.awt.*;


/**
 * Default entry point
 *
 * @author Mathias Bjerke
 */
public class App {
	public static void main( String[] args ) throws Exception {
		ScreenManager sm = new ScreenManager();

		DisplayMode modes[] = sm.getCompatibleDisplayModes();

		for( DisplayMode mode : modes ) {
			if( mode.getWidth() == 640 && mode.getHeight() == 480 ) {
				sm.setFullScreen( mode );
			}
		}

		JFrame window = sm.getWindow();
		
		Graphics2D g2 = (Graphics2D) window.getGraphics();

		g2.drawString( "Hello", 20, 20 );
	}
}
