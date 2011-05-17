package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity (name = "Contact")
public class Contact {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contact_ID")
	private int contactID;
	
	@Column(name = "Data")
	private String data;
	
	@Column(name = "Contact_Type")
	private String contactType;

	public Contact() {
		super();
	}

	public Contact(String data, String contactType) {
		super();
		this.data = data;
		this.contactType = contactType;
	}

	public int getContactID() {
		return contactID;
	}

	public String getData() {
		return data;
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}
	
}
