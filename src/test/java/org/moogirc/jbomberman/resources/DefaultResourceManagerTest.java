package org.moogirc.jbomberman.resources;


import org.junit.*;
import org.newdawn.slick.*;
import org.newdawn.slick.openal.*;

import java.io.*;

import static org.junit.Assert.*;


/**
 *
 *
 * @author Mariann Orvedal <mariann.orvedal@gmail.no>
 */
public class DefaultResourceManagerTest {
	private ResourceManager resourceManager;


	@Before
	public void setUp() {
		resourceManager = new DefaultResourceManager();
	}


	@Test
	public void testLoad() {
		ResourceBundle resourceBundle;
		FileLister resourceFile;
		ImageWrapper mainMenu;
		Audio bringItOn;
		Animation dance;

		resourceFile = new FakeFileLister( new File( "data/resources/jbomberman/resources.xml" ) );
		resourceBundle = new ResourceBundle( resourceFile );
		
		resourceManager.load( resourceBundle );

		mainMenu = resourceManager.getImageById( "mainmenu" );
		assertNotNull( mainMenu );

		bringItOn = resourceManager.getAudioById( "bringiton" );
		assertNotNull( bringItOn );

		dance = resourceManager.getAnimationById( "dance" );
		assertNotNull( dance );
	}
}
