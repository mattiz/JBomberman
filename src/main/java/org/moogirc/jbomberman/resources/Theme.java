package org.moogirc.jbomberman.resources;


/**
 * This class represents a theme
 *
 * @author Mariann Orvedal <mariann.orvedal@gmail.com>
 */
public class Theme {
	private String name;
	private String author;
	private String version;
	private FileLister resourceFile;


	public Theme( String name, String author, String version, FileLister resourceFile ) {
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


	public FileLister getResourceFile() {
		return resourceFile;
	}
}
