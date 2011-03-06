package org.moogirc.jbomberman.states;


import org.moogirc.jbomberman.boards.*;
import org.moogirc.jbomberman.objects.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * The state for the game screen
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class GameplayState extends BasicGameState {
	private int stateID = -1;
	private Board board;


	public GameplayState( int stateID ) {
		this.stateID = stateID;
	}


	public int getID() {
		return stateID;
	}


	public void init( GameContainer gc, StateBasedGame sbg ) throws SlickException {
		board = BoardFactory.createBoard( "test" );
		board.addGameObject( new Player() );
	}


	public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		board.update( gc, sbg, delta );
	}


	public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
		board.render( gc, sbg, g );
	}
}
