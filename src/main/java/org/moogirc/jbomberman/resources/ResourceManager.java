package org.moogirc.jbomberman.resources;


import org.newdawn.slick.*;
import org.newdawn.slick.openal.*;


/**
 * Manage resources for one given theme
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public interface ResourceManager {
	public ImageWrapper getImageById( String id );
	public Animation getAnimationById( String id );
	public Audio getAudioById( String id );
	public void load( ResourceBundle resourceBundle );
	public boolean isLoaded();
	public int getNumberOfResources();
	public int getNumberOfLoadedResources();
}
