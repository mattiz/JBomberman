package org.moogirc.jbomberman.resources;


import org.junit.*;
import java.io.*;
import java.util.*;
import static org.junit.Assert.*;


/**
 * Tests for the class ResourceManagerFactory
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceManagerFactoryTest {
	private ResourceManagerFactory resourceManagerFactory;


	@Before
	public void setUp() {
		resourceManagerFactory = new ResourceManagerFactory();
	}


	@Test
	public void testGetThemes() {
		List<Theme> themes;
		Theme theme1;
		Theme theme2;

		themes = resourceManagerFactory.getThemes( new FakeFileLister( new File( "data/themes" ) ) );
		
		assertEquals( themes.size(), 2 );

		theme1 = themes.get( 0 );
		assertEquals( "Original Bomberman", theme1.getName() );
		assertEquals( "Interplay", theme1.getAuthor() );
		assertEquals( "1.0", theme1.getVersion() );
		assertEquals( "data/themes/original/resources.xml", theme1.getResourceFile().getPath() );

		theme2 = themes.get( 1 );
		assertEquals( "JBomberman", theme2.getName() );
		assertEquals( "MooG Crew", theme2.getAuthor() );
		assertEquals( "1.0", theme2.getVersion() );
		assertEquals( "data/themes/jbomberman/resources.xml", theme2.getResourceFile().getPath() );
	}


	@Test
	public void testCreateResourceManager() {

	}
}
