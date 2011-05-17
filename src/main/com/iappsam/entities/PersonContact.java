package com.iappsam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PersonContact implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1233453309200683671L;

	@Id
	@Column(name = "Person_ID")
	private int personID;
	
	@Id
	@Column(name = "Contact_ID")
	private int contactID;

	public PersonContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PersonContact(int personID, int contactID) {
		super();
		this.personID = personID;
		this.contactID = contactID;
	}

	public int getPersonID() {
		return personID;
	}

	public int getContactID() {
		return contactID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}
	
}
