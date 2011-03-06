package org.moogirc.jbomberman;


import org.moogirc.jbomberman.gamestates.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * The main class that set up states and invoke the game
 * 
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class JBomberman extends StateBasedGame {
	public static final int MAIN_MENU_STATE = 0;
	public static final int GAMEPLAY_STATE  = 1;
	public static final String GAME_TITLE = "JBomberman";


	public JBomberman() {
		super( GAME_TITLE );

		addState( new MainMenuState( MAIN_MENU_STATE ) );
		addState( new GameplayState( GAMEPLAY_STATE ) );
		enterState( MAIN_MENU_STATE );
	}


	public void initStatesList( GameContainer gameContainer ) throws SlickException {
		getState( MAIN_MENU_STATE ).init( gameContainer, this );
		getState( GAMEPLAY_STATE ).init( gameContainer, this );
	}


	public static void main( String[] args ) throws SlickException {
		AppGameContainer app = new AppGameContainer( new JBomberman() );

		app.setDisplayMode( 640, 480, false );
		app.start();
	}
}
