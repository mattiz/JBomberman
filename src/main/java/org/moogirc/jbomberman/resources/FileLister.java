package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * Description
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public interface FileLister {
	public FileLister[] listFiles();
	public FileLister getChild( String child );
	public String getPath();
	public Reader openReader();
}
