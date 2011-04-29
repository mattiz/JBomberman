package org.moogirc.jbomberman.resources;


import org.moogirc.jbomberman.resources.loaders.*;


/**
 * Load an fake image
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class FakeImageResourceLoader implements ResourceLoader<ImageWrapper> {
	public ImageWrapper load( FileLister filename ) {
		return new ImageWrapper( null );
	}
}
