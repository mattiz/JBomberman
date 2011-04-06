package org.moogirc.jbomberman.resources;


import java.io.*;


/**
 * An implementation of the FileLister interface used for unit testing
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class StubFileLister implements FileLister {
	private File file;


	public StubFileLister( File file ) {
		this.file = file;
	}


	public FileLister[] listFiles() {
		return new FileLister[] {
			new StubFileLister( new File( file, "original" ) ),
			new StubFileLister( new File( file, "jbomberman" ) )
		};
	}
	

	public FileLister getChild( String child ) {
		return new StubFileLister( new File( file, "resources.xml" ) );
	}


	public String getPath() {
		return file.getPath();
	}


	public Reader openReader() {
		String jbombermanResources =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"\n" +
				"<resources>\n" +
				"\t<name>JBomberman</name>\n" +
				"\t<author>MooG Crew</author>\n" +
				"\t<version>1.0</version>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>field0</id>\n" +
				"\t\t<type>image</type>\n" +
				"\t\t<loader>PngImageResourceLoader</loader>\n" +
				"\t\t<file>images/field0.png</file>\n" +
				"\t</resource>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>mainmenu</id>\n" +
				"\t\t<type>image</type>\n" +
				"\t\t<loader>PngImageResourceLoader</loader>\n" +
				"\t\t<file>images/mainmenu.png</file>\n" +
				"\t</resource>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>bringiton</id>\n" +
				"\t\t<type>sound</type>\n" +
				"\t\t<loader>Mp3SoundResourceLoader</loader>\n" +
				"\t\t<file>sounds/bringiton.mp3</file>\n" +
				"\t</resource>\n" +
				"</resources>";

		String originalResources = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
				"\n" +
				"<resources>\n" +
				"\t<name>Original Bomberman</name>\n" +
				"\t<author>Interplay</author>\n" +
				"\t<version>1.0</version>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>field0</id>\n" +
				"\t\t<type>image</type>\n" +
				"\t\t<loader>PcxImageResourceLoader</loader>\n" +
				"\t\t<file>RES/FIELD0.PCX</file>\n" +
				"\t</resource>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>mainmenu</id>\n" +
				"\t\t<type>image</type>\n" +
				"\t\t<loader>PcxImageResourceLoader</loader>\n" +
				"\t\t<file>RES/MAINMENU.PCX</file>\n" +
				"\t</resource>\n" +
				"\n" +
				"\t<resource>\n" +
				"\t\t<id>bringiton</id>\n" +
				"\t\t<type>sound</type>\n" +
				"\t\t<loader>RssSoundResourceLoader</loader>\n" +
				"\t\t<file>SOUND/BRINGITON.RSS</file>\n" +
				"\t</resource>\n" +
				"</resources>";
		
		if( file.getPath().indexOf( "original" ) != -1 )
			return new StringReader( originalResources );
		else
			return new StringReader( jbombermanResources );
	}
}
