package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * Factory to create new resoruce managers
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceManagerFactory {
	/**
	 * Create a resource manager from a resources.xml file.
	 * @param xmlResourceFilename The resource.xml file where we load resources
	 * @param eagerLoading set to true if you want to load all resources in memory, false if not
	 * @return a newly constructed resource manager
	 */
	public ResourceManager createResourceManager( File xmlResourceFilename, boolean eagerLoading ) {
		return null;
	}
}
