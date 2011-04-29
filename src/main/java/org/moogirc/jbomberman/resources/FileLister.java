package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * List and open files in the file system
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public interface FileLister {
	public FileLister[] listFiles();
	public FileLister getChild( String child );
	public String getPath();
	public Reader openReader();
	public FileLister getParentFile();
}
