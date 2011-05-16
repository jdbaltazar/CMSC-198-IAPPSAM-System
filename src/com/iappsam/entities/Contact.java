package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Contact {
	
	public static final String FOR_SUPPLIER = "FOR_SUPPLIER";
	public static final String FOR_DIVISIONOFFICE = "FOR_DIVISIONOFFICE";
	public static final String FOR_PERSON = "FOR_PERSON";
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Contact_ID")
	private int contactID;
	
	@Column(name = "Data")
	private String data;
	
	@Column(name = "Contact_Type")
	private String contactType;
	
	@Column(name = "Supplier_ID")
	private int supplierID;
	
	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;
	
	@Column(name = "Person_ID")
	private int personID;

	public Contact() {
		super();
	}

	public Contact(String data, String contactType, int supplierID, int divisionOfficeID, int personID) {
		super();
		this.data = data;
		this.contactType = contactType;
		this.supplierID = supplierID;
		this.divisionOfficeID = divisionOfficeID;
		this.personID = personID;
	}

//	public Contact(String data, String contactType, int idOfOwner, String typeOfOwner) {
//		super();
//		this.data = data;
//		this.contactType = contactType;
//		if(typeOfOwner.equalsIgnoreCase(Contact.FOR_DIVISIONOFFICE))
//			this.divisionOfficeID = idOfOwner;
//		if(typeOfOwner.equalsIgnoreCase(Contact.FOR_PERSON))
//			this.personID = idOfOwner;
//		if(typeOfOwner.equalsIgnoreCase(Contact.FOR_SUPPLIER))
//			this.supplierID = idOfOwner;
//	}

	public int getContactID() {
		return contactID;
	}

	public String getData() {
		return data;
	}

	public String getContactType() {
		return contactType;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int getPersonID() {
		return personID;
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

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setPersonID(int personID) {
		this.personID = personID;
	}
	
}
