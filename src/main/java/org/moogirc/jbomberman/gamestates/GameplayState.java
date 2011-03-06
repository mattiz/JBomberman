package org.moogirc.jbomberman.gamestates;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * The state for the game screen
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class GameplayState extends BasicGameState {
	private int stateID = -1;


	public GameplayState( int stateID ) {
		this.stateID = stateID;
	}


	public int getID() {
		return stateID;
	}


	public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {
	}


	public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		Input input = gc.getInput();
	}


	public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
		g.drawString( "Gameplay", 270, 200 );
	}
}
