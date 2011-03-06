package org.moogirc.jbomberman.objects;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * Representation of a player on the game board
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class Player extends GameObject {
	private final static int MOVE_UP    = 0;
	private final static int MOVE_DOWN  = 1;
	private final static int MOVE_LEFT  = 2;
	private final static int MOVE_RIGHT = 3;


	/**
	 * The players name
	 */
	private String name;


	/**
	 * The players color
	 */
	private Color color;


	/**
	 * Contain the players speed
	 */
	private int speed;


	/**
	 * Make the player move in a given direction
	 * @param direction which direction to move. You can choose between the constants MOVE_UP, MOVE_DOWN,
	 * 					MOVE_LEFT and MOVE_RIGHT
	 */
	public void move( int direction ) {
		// Not implemented
	}


	/**
	 * Stop the players movement
	 */
	public void stop() {
		// Not implemented
	}


	/**
	 * Change the players speed
	 * @param speed
	 */
	public void changeSpeed( int speed ) {
		this.speed += speed;
	}


	public void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException {
	}


	public void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException {
		// Drawing a circle for testing
		g.drawOval( 100, 100, 30, 30 );
	}
}
