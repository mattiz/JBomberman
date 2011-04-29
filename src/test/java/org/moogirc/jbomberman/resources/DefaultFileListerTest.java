package org.moogirc.jbomberman.resources;


import org.junit.*;

import static org.junit.Assert.*;


/**
 * Tests for the class ResourceBundleFactory
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class DefaultFileListerTest {
	@Test
	public void testDefaultFileLister() {
		FileLister fileLister;

		fileLister = new DefaultFileLister( new FakeFile( "path/to" ) );

		assertEquals( "path/to", fileLister.getPath() );

		assertEquals( "path/to/file1.txt", fileLister.listFiles()[0].getPath() );
		assertEquals( "path/to/file2.txt", fileLister.listFiles()[1].getPath() );

		assertEquals( "path/to/file1.txt", fileLister.getChild( "file1.txt" ).getPath() );
	}
}
