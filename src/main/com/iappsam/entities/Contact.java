package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name = "Contact")
public class Contact {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contact_ID")
	private int contactID;

	@Column(name = "Data")
	private String data;

	@Column(name = "Contact_Type")
	private ContactType contactType;

	public Contact() {
		super();
	}

	public Contact(String data, ContactType contactType) {
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

	public ContactType getType() {
		return contactType;
	}

	public void setId(int contactID) {
		this.contactID = contactID;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setType(ContactType type) {
		this.contactType = type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + contactID;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contact other = (Contact) obj;
		if (contactID != other.contactID)
			return false;
		return true;
	}
}
