package org.moogirc.jbomberman.resources;


import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.util.*;


/**
 * Factory to create new resource managers
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class ResourceManagerFactory {
	/**
	 * Find all themes under a given folder structure
	 * @param themeDirectory the directory where we should search for themes
	 * @return a list of themes
	 */
	public List<Theme> getThemes( FileLister themeDirectory ) {
		List<Theme> themes;

		themes = new ArrayList<Theme>();

		for( FileLister file : themeDirectory.listFiles() ) {
			FileLister fl = file.getChild( "resources.xml" );

			themes.add( getTheme( fl ) );
		}

		return themes;
	}


	private Theme getTheme( FileLister fl ) {
		String name = null;
		String author = null;
		String version = null;
		XMLInputFactory factory;
		XMLEventReader eventReader;

		try {
			factory = XMLInputFactory.newInstance();
			eventReader = factory.createXMLEventReader( fl.openReader() );

			while( eventReader.hasNext() ) {
				XMLEvent event = eventReader.nextEvent();

				if( event.isStartElement() ) {

					if( event.asStartElement().getName().getLocalPart().equals( "name" ) ) {
						event = eventReader.nextEvent();
						name = event.asCharacters().getData();
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "author" ) ) {
						event = eventReader.nextEvent();
						author = event.asCharacters().getData();
						continue;
					}
					
					if( event.asStartElement().getName().getLocalPart().equals( "version" ) ) {
						event = eventReader.nextEvent();
						version = event.asCharacters().getData();
					}
				}
			}

		} catch( Exception e ) {
			e.printStackTrace();
		}

		return new Theme( name, author, version, fl );
	}


	/**
	 * Create a resource manager from a resources.xml file.
	 * @param theme The theme we want to load
	 * @param eagerLoading set to true if you want to load all resources in memory, false if not
	 * @return a newly constructed resource manager
	 */
	public ThemeResourceManager createResourceManager( Theme theme, boolean eagerLoading ) {
		return null;
	}
}
