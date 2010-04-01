package org.moogirc.jbomberman;

import javax.swing.*;
import java.awt.*;
import java.awt.BufferCapabilities.FlipContents;
import java.awt.image.BufferStrategy;


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
			if( mode.getWidth() == 1680 && mode.getHeight() == 1050 ) {
				sm.setFullScreen( mode );
				break;
			}
		}

		SoundManager soundmanager = new SoundManager("../JBomberman/resources/AUTORUN.WAV", 0.0f);
		soundmanager.start();
		JFrame window = sm.getWindow();
		window.setBackground(Color.black);
		window.setForeground(Color.yellow);
		BufferCapabilities bc = new BufferCapabilities(new ImageCapabilities(true), 
				new ImageCapabilities(true), FlipContents.BACKGROUND);
		window.createBufferStrategy(2, bc);
		BufferStrategy bs = window.getBufferStrategy();
		for(int i = 0; i < 100; i++) {
			Graphics g = bs.getDrawGraphics();
			if(!bs.contentsLost()) {
				render(g, i);
				bs.show();
				g.dispose();
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException ie) {
			}
		}
		System.exit(0);
	}
	
	public static void render(Graphics g, int i) {
		g.fill3DRect(220+(i*5), 220+(i*5), 220, 220, true);
	}
}
