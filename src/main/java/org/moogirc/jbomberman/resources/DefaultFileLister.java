package org.moogirc.jbomberman.resources;


import java.io.*;
import java.util.*;


/**
 * Actual implementation of FileLister
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class DefaultFileLister implements FileLister {
	private File file;


	public DefaultFileLister( File file ) {
		this.file = file;
	}


	public FileLister[] listFiles() {
		List<FileLister> files;

		files = new ArrayList<FileLister>();

		for( File f : file.listFiles() ) {
			files.add( new DefaultFileLister( f ) );
		}

		return files.toArray( new FileLister[ files.size() ] );
	}


	public FileLister getChild( final String child ) {
		File[] files;

		files = file.listFiles( new FilenameFilter() {
			public boolean accept( File file, String s ) {
				return s.equals( child );
			}
		});

		return new DefaultFileLister( files[ 0 ] );
	}


	public String getPath() {
		return file.getPath();
	}


	public FileLister getParentFile() {
		return new DefaultFileLister( file.getParentFile() );
	}


	public Reader openReader() {
		Reader reader = null;

		try {
			reader = new FileReader( file );
			
		} catch( FileNotFoundException e ) {
			e.printStackTrace();
		}

		return reader;
	}
}
