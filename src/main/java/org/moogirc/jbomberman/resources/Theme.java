package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * This class represents a theme
 *
 * @author Mariann Orvedal <mariann.orvedal@gmail.com>
 */
public class Theme {
	private String name;
	private String author;
	private String version;
	private File resourceFile;


	public Theme( String name, String author, String version, File resourceFile ) {
		this.name = name;
		this.author = author;
		this.version = version;
		this.resourceFile = resourceFile;
	}


	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}


	public String getVersion() {
		return version;
	}


	public File getResourceFile() {
		return resourceFile;
	}
}
