package org.moogirc.jbomberman.resources;


import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.util.*;


/**
 * Factory to create new resource managers
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceBundleFactory {
	/**
	 * Find all themes under a given folder structure
	 * @param themeDirectory the directory where we should search for themes
	 * @return a list of themes
	 */
	public List<ResourceBundle> getResourceBundles( FileLister themeDirectory ) {
		List<ResourceBundle> resourceBundles;

		resourceBundles = new ArrayList<ResourceBundle>();

		for( FileLister file : themeDirectory.listFiles() ) {
			FileLister fl = file.getChild( "resources.xml" );

			resourceBundles.add( new ResourceBundle( fl ) );
		}

		return resourceBundles;
	}


	public ResourceBundle getResourceBundleByName( String name ) {
		return null;
	}
}
