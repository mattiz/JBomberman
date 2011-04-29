package org.moogirc.jbomberman.resources;


import org.moogirc.jbomberman.resources.loaders.*;
import org.newdawn.slick.*;
import org.newdawn.slick.openal.*;

import java.io.*;
import java.util.*;


/**
 * Description
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class DefaultResourceManager implements ResourceManager {
	private Map<String,ImageWrapper> images;
	private Map<String,Animation> animations;
	private Map<String,Audio> sounds;


	public ImageWrapper getImageById( String id ) {
		return images.get( id );
	}


	public Animation getAnimationById( String id ) {
		return animations.get( id );
	}


	public Audio getAudioById( String id ) {
		return sounds.get( id );
	}


	public void load( ResourceBundle resourceBundle ) {
		//images = new ArrayList<Image>();
		images = new HashMap<String, ImageWrapper>();
		animations = new HashMap<String, Animation>();
		sounds = new HashMap<String, Audio>();

		for( Resource resource : resourceBundle.getResources() ) {
			try {
				if( resource.getType().equals( "image" ) ) {
					ResourceLoader<ImageWrapper> loader = (ResourceLoader<ImageWrapper>) resource.getLoader().newInstance();
					ImageWrapper image = loader.load( resource.getFile() );
					images.put( resource.getId(), image );

				} else if( resource.getType().equals( "sound" ) ) {
					ResourceLoader<Audio> loader = (ResourceLoader<Audio>) resource.getLoader().newInstance();
					Audio audio = loader.load( resource.getFile() );
					sounds.put( resource.getId(), audio );

				} else if( resource.getType().equals( "animation" ) ) {
					ResourceLoader<Animation> loader = (ResourceLoader<Animation>) resource.getLoader().newInstance();
					Animation animation = loader.load( resource.getFile() );
					animations.put( resource.getId(), animation );
				}
				
			} catch( InstantiationException e ) {
				e.printStackTrace();
			} catch( IllegalAccessException e ) {
				e.printStackTrace();
			}
		}
	}


	public boolean isLoaded() {
		return false;
	}


	public int getNumberOfResources() {
		return 0;
	}


	public int getNumberOfLoadedResources() {
		return 0;
	}
}
