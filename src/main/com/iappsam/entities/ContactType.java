package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contact_Type")
public class ContactType {
	
	public static final String LANDLINE = "LANDLINE";
	public static final String MOBILE = "MOBILE";
	public static final String FAX = "FAX";
	public static final String EMAIL = "EMAIL";
	public static final String WEBSITE = "WEBSITE";
	public static final String OTHERS = "OTHERS";
	
	@Id
	@Column (name = "Contact_Type")
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
