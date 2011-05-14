package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity (name = "Contact_Type")
public class ContactType {
	
	@Id
	@Column (name = "Contact_Type", nullable = false, length = 45)
	private String contactType;

	public ContactType() {
		super();
	}

	public ContactType(String contactType) {
		super();
		setContactType(contactType);
	}

	public String getContactType() {
		return contactType;
	}

	public void setContactType(String contactType) {
		this.contactType = contactType;
	}

}
