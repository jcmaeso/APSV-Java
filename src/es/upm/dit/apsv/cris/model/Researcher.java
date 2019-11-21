package es.upm.dit.apsv.cris.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class Researcher implements Serializable {
	@Id
	protected String id;
	protected String name;
	protected String lastname;
	protected String email;
	protected String password;
	protected String scopusURL;
	@ElementCollection (fetch = FetchType.EAGER)
	protected Set<Publication> publications;
	
	
	public Researcher() {
		super();
		publications = new HashSet<Publication>();
	}


	public Researcher(String id, String name, String lastname, String email, String password, String scopusURL,
			Set<Publication> publications) {
		super();
		this.id = id;
		this.name = name;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.scopusURL = scopusURL;
		this.publications = publications;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getScopusURL() {
		return scopusURL;
	}


	public void setScopusURL(String scopusURL) {
		this.scopusURL = scopusURL;
	}


	public Set<Publication> getPublications() {
		return publications;
	}


	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}


	@Override
	public String toString() {
		return "Researcher [id=" + id + ", name=" + name + ", lastname=" + lastname + ", email=" + email + ", password="
				+ password + ", scopusURL=" + scopusURL + ", publications=" + publications + "]";
	}
	
	
}
