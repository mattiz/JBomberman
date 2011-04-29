package org.moogirc.jbomberman.resources;


import org.moogirc.jbomberman.resources.loaders.*;
import org.newdawn.slick.*;


/**
 * Load a fake animation
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class FakeAnimationResourceLoader implements ResourceLoader<Animation> {
	public Animation load( FileLister filename ) {
		return new Animation();
	}
}
