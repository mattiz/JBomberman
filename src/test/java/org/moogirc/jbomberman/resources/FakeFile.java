package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * Fake File class used in unit tests
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class FakeFile extends File {
	public FakeFile( String s ) {
		super( s );
	}


	@Override
	public File[] listFiles() {
		return new FakeFile[] {
			new FakeFile( "path/to/file1.txt" ),
			new FakeFile( "path/to/file2.txt" )
		};
	}


	@Override
	public FakeFile[] listFiles( FilenameFilter filenameFilter ) {
		return new FakeFile[] {
			new FakeFile( "path/to/file1.txt" )
		};
	}
}
