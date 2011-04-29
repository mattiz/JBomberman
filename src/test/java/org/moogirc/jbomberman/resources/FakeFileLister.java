package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * An implementation of the FileLister interface used for unit testing
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class FakeFileLister implements FileLister {
	private File file;


	public FakeFileLister( File file ) {
		this.file = file;
	}


	public FileLister[] listFiles() {
		return new FileLister[] {
			new FakeFileLister( new File( file, "original" ) ),
			new FakeFileLister( new File( file, "jbomberman" ) )
		};
	}
	

	public FileLister getChild( String child ) {
		return new FakeFileLister( new File( file, child ) );
	}


	public String getPath() {
		return file.getPath();
	}


	public FileLister getParentFile() {
		return new FakeFileLister( file.getParentFile() );
	}


	public Reader openReader() {
		String jbombermanResources =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"\n" +
				"<resourceBundle>\n" +
				"\t<name>JBomberman</name>\n" +
				"\t<author>MooG Crew</author>\n" +
				"\t<version>1.0</version>\n" +
				"\n" +
				"\t<resources>\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>field0</id>\n" +
				"\t\t\t<type>image</type>\n" +
				"\t\t\t<loader>org.moogirc.jbomberman.resources.FakeImageResourceLoader</loader>\n" +
				"\t\t\t<file>images/field0.png</file>\n" +
				"\t\t</resource>\n" +
				"\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>mainmenu</id>\n" +
				"\t\t\t<type>image</type>\n" +
				"\t\t\t<loader>org.moogirc.jbomberman.resources.FakeImageResourceLoader</loader>\n" +
				"\t\t\t<file>images/mainmenu.png</file>\n" +
				"\t\t</resource>\n" +
				"\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>bringiton</id>\n" +
				"\t\t\t<type>sound</type>\n" +
				"\t\t\t<loader>org.moogirc.jbomberman.resources.FakeAudioResourceLoader</loader>\n" +
				"\t\t\t<file>sounds/bringiton.mp3</file>\n" +
				"\t\t</resource>\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>dance</id>\n" +
				"\t\t\t<type>animation</type>\n" +
				"\t\t\t<loader>org.moogirc.jbomberman.resources.FakeAnimationResourceLoader</loader>\n" +
				"\t\t\t<file>animations/dance.png</file>\n" +
				"\t\t</resource>\n" +
				"\t</resources>\n" +
				"</resourceBundle>";

		String originalResources =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"\n" +
				"<resourceBundle>\n" +
				"\t<name>Original Bomberman</name>\n" +
				"\t<author>Interplay</author>\n" +
				"\t<version>1.0</version>\n" +
				"\n" +
				"\t<resources>\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>field0</id>\n" +
				"\t\t\t<type>image</type>\n" +
				"\t\t\t<loader>PcxImageResourceLoader</loader>\n" +
				"\t\t\t<file>RES/FIELD0.PCX</file>\n" +
				"\t\t</resource>\n" +
				"\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>mainmenu</id>\n" +
				"\t\t\t<type>image</type>\n" +
				"\t\t\t<loader>PcxImageResourceLoader</loader>\n" +
				"\t\t\t<file>RES/MAINMENU.PCX</file>\n" +
				"\t\t</resource>\n" +
				"\n" +
				"\t\t<resource>\n" +
				"\t\t\t<id>bringiton</id>\n" +
				"\t\t\t<type>sound</type>\n" +
				"\t\t\t<loader>RssSoundResourceLoader</loader>\n" +
				"\t\t\t<file>SOUND/BRINGITON.RSS</file>\n" +
				"\t\t</resource>\n" +
				"\t</resources>\n" +
				"</resourceBundle>";
		
		if( file.getPath().indexOf( "original" ) != -1 )
			return new StringReader( originalResources );
		else
			return new StringReader( jbombermanResources );
	}
}
