package org.moogirc.jbomberman.resources;


import javax.xml.stream.*;
import javax.xml.stream.events.*;
import java.util.*;


/**
 * This class represents a theme
 *
 * @author Mariann Orvedal <mariann.orvedal@gmail.com>
 */
public class ResourceBundle {
	private String name;
	private String author;
	private String version;
	private List<Resource> resources;


	public ResourceBundle( FileLister resourceBundleFilename ) {
		resources = new ArrayList<Resource>();
		loadResourceBundle( resourceBundleFilename );
	}


	private void loadResourceBundle( FileLister resourceBundleFilename ) {
		XMLInputFactory factory;
		XMLEventReader eventReader;
		Resource tempResource = null;

		try {
			factory = XMLInputFactory.newInstance();
			eventReader = factory.createXMLEventReader( resourceBundleFilename.openReader() );

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
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "resource" ) ) {
						tempResource = new Resource();
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "id" ) ) {
						event = eventReader.nextEvent();
						tempResource.setId( event.asCharacters().getData() );
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "type" ) ) {
						event = eventReader.nextEvent();
						tempResource.setType( event.asCharacters().getData() );
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "loader" ) ) {
						event = eventReader.nextEvent();
						tempResource.setLoader( Class.forName( event.asCharacters().getData() ) );
						continue;
					}

					if( event.asStartElement().getName().getLocalPart().equals( "file" ) ) {
						event = eventReader.nextEvent();
						String filename = event.asCharacters().getData();
						tempResource.setFile( resourceBundleFilename.getParentFile().getChild( filename ) );
						continue;
					}
				}

				if( event.isEndElement() ) {
					if( event.asEndElement().getName().getLocalPart().equals( "resource" ) ) {
						resources.add( tempResource );
						continue;
					}
				}
			}

		} catch( Exception e ) {
			e.printStackTrace();
		}
	}


	public String getName() {
		return name;
	}


	public String getAuthor() {
		return author;
	}


	public String getVersion() {
		return version;
	}


	public List<Resource> getResources() {
		return resources;
	}
}
