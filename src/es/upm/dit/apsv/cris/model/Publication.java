package es.upm.dit.apsv.cris.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Publication {
	@Id
	protected String id;
	protected String title;
	protected String publicationName;
	protected String publicationDate;
	protected String authors;
	protected int  citeCount;
	
	public Publication() {
		super();
	}


	public Publication(String id, String title, String publicationName, String publicationDate, String authors) {
		super();
		this.id = id;
		this.title = title;
		this.publicationName = publicationName;
		this.publicationDate = publicationDate;
		this.authors = authors;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getPublicationName() {
		return publicationName;
	}


	public void setPublicationName(String publicationName) {
		this.publicationName = publicationName;
	}


	public String getPublicationDate() {
		return publicationDate;
	}


	public void setPublicationDate(String publicationDate) {
		this.publicationDate = publicationDate;
	}


	public String getAuthors() {
		return authors;
	}


	public void setAuthors(String authors) {
		this.authors = authors;
	}


	public int getCiteCount() {
		return citeCount;
	}


	public void setCiteCount(int citeCount) {
		this.citeCount = citeCount;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
