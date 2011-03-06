package org.moogirc.jbomberman.states;


import org.moogirc.jbomberman.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * The state for the main menu
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class MainMenuState extends BasicGameState {
	private int stateID = -1;


	public MainMenuState( int stateID ) {
		this.stateID = stateID;
	}


	public int getID() {
		return stateID;
	}


	public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {
	}


	public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		Input input = gc.getInput();

		if( input.isKeyDown( Input.KEY_ENTER ) ) {
			sbg.enterState( JBomberman.GAMEPLAY_STATE );
		}
	}


	public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
		g.drawString( "Main menu - press enter to change state", 150, 200 );
	}
}
