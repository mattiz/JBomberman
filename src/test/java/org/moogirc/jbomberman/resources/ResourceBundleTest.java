package org.moogirc.jbomberman.resources;


import org.junit.*;
import java.io.*;
import static org.junit.Assert.*;


/**
 * Tests for the class ResourceBundleFactory
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceBundleTest {
	@Test
	public void testResourceBundle() {
		ResourceBundle resourceBundle;

		resourceBundle = new ResourceBundle( new FakeFileLister( new File( "data/resources/jbomberman/resources.xml" ) ) );

		assertEquals( "JBomberman", resourceBundle.getName() );
		assertEquals( "MooG Crew", resourceBundle.getAuthor() );
		assertEquals( "1.0", resourceBundle.getVersion() );

		for( Resource resource : resourceBundle.getResources() ) {
			assertNotNull( resource.getFile() );
			assertNotNull( resource.getId() );
			assertNotNull( resource.getLoader() );
			assertNotNull( resource.getType() );
		}
	}
}
