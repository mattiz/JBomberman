package org.moogirc.jbomberman.resources;


/**
 * Description
 *
 * @author Mathias Bjerke <mathias@verida.no>
 */
public class Resource {
	private String id;
	private String type;
	private Class loader;
	private FileLister file;

	public Resource() {
	}


	public Resource( String id, String type, Class loader, FileLister file ) {
		this.id = id;
		this.type = type;
		this.loader = loader;
		this.file = file;
	}


	public String getId() {
		return id;
	}


	public void setId( String id ) {
		this.id = id;
	}


	public String getType() {
		return type;
	}


	public void setType( String type ) {
		this.type = type;
	}


	public Class getLoader() {
		return loader;
	}


	public void setLoader( Class loader ) {
		this.loader = loader;
	}


	public FileLister getFile() {
		return file;
	}


	public void setFile( FileLister file ) {
		this.file = file;
	}
}
