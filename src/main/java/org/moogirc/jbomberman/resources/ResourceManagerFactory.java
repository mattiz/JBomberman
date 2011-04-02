package org.moogirc.jbomberman.resources;


import java.io.*;
import java.util.*;


/**
 * Factory to create new resoruce managers
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceManagerFactory {
	/**
	 * Find all themes under a given folder structure
	 * @param themeDirectory the directory where we should search for themes
	 * @return a list of themes
	 */
	public List<Theme> getThemes( File themeDirectory ) {
		return null;
	}


	/**
	 * Create a resource manager from a resources.xml file.
	 * @param theme The theme we want to load
	 * @param eagerLoading set to true if you want to load all resources in memory, false if not
	 * @return a newly constructed resource manager
	 */
	public ThemeResourceManager createResourceManager( Theme theme, boolean eagerLoading ) {
		return null;
	}
}
