package org.moogirc.jbomberman.resources;


import org.moogirc.jbomberman.resources.loaders.*;
import org.newdawn.slick.openal.*;


/**
 * Load a fake sound
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class FakeAudioResourceLoader implements ResourceLoader<Audio> {
	public Audio load( FileLister filename ) {
		return new NullAudio();
	}
}
