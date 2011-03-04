package org.moogirc.jbomberman;


import org.newdawn.slick.*;


/**
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class JBomberman extends BasicGame {
	public JBomberman() {
		super( "JBomberman" );
	}


	@Override
	public void init( GameContainer gc ) throws SlickException {

	}


	@Override
	public void update( GameContainer gc, int delta ) throws SlickException {
		Input input = gc.getInput();
	}


	public void render( GameContainer gc, Graphics g ) throws SlickException {
		g.drawString( "Heisann verden", 300, 200 );
	}


	public static void main( String[] args ) throws SlickException {
		AppGameContainer app = new AppGameContainer( new JBomberman() );

		app.setDisplayMode( 640, 480, false );
		app.start();
	}
}
