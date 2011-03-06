package org.moogirc.jbomberman.boards;


import org.moogirc.jbomberman.objects.*;
import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import java.util.*;


/**
 * Klass representing a game board
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class Board {
	private Image background;
	private List<GameObject> gameObjects;


	public Board() {
		gameObjects = new ArrayList<GameObject>();
	}


	public void addGameObject( GameObject gameObject ) {
		gameObjects.add( gameObject );
	}


	public void setBackground( Image background ) {
		this.background = background;
	}


	/**
	 * Update method for this board. It's parameters is basically a copy of the update method in
	 * http://slick.cokeandcode.com/javadoc/org/newdawn/slick/state/GameState.html
	 */
	public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
		for( GameObject gameObject : gameObjects ) {
			gameObject.update( gc, sbg, delta );
		}
	}


	/**
	 * Render method for this board. It's parameters is basically a copy of the render method in
	 * http://slick.cokeandcode.com/javadoc/org/newdawn/slick/state/GameState.html
	 */
	public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
		// Render background
		background.draw( 0, 0 );

		for( GameObject gameObject : gameObjects ) {
			gameObject.render( gc, sbg, g );
		}
	}
}
