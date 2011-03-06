package org.moogirc.jbomberman.boards;


import org.newdawn.slick.*;


/**
 * Factory to create new game boards
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class BoardFactory {
	public static Board createBoard( String name ) throws SlickException {
		// Load board definition from file and construct a new Board object

		// Hardcoded board for testing
		Board board = new Board();
		board.setBackground( new Image( "data/images/field0.png" ) );

		return board;
	}
}
