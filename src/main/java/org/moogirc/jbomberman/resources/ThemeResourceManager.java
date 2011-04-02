package org.moogirc.jbomberman.resources;


import org.newdawn.slick.*;


/**
 * Manage resources for one given theme
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public interface ThemeResourceManager {
	public Image getImageById( String id );
	public Animation getAnimationById( String id );
	public Sound getSoundById( String id );
}
