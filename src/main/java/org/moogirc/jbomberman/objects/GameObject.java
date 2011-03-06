package org.moogirc.jbomberman.objects;


import org.newdawn.slick.*;
import org.newdawn.slick.state.*;


/**
 * Abstract representation of an object on the game board
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public abstract class GameObject {
	/**
	 * Game objects X position on the board
	 */
	protected int xPos;


	/**
	 * Game objects Y position on the board
	 */
	protected int yPos;


	/**
	 * Update method for this game object. It's parameters is basically a copy of the update method in
	 * http://slick.cokeandcode.com/javadoc/org/newdawn/slick/state/GameState.html
	 */
	public abstract void update( GameContainer gc, StateBasedGame sbg, int delta ) throws SlickException;


	/**
	 * Render method for this game object. It's parameters is basically a copy of the render method in
	 * http://slick.cokeandcode.com/javadoc/org/newdawn/slick/state/GameState.html
	 */
	public abstract void render( GameContainer gc, StateBasedGame sbg, Graphics g ) throws SlickException;
}
