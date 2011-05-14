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
	@Column(name = "Contact_ID", nullable = false)
	private int contactID;
	
	@Column(name = "Data", nullable = false, length = 45)
	private String data;
	
	@Column(name = "Contact_Type", nullable = false, length = 45)
	private String contactType;
	
	@Column(name = "Supplier_ID", nullable = true)
	private int supplierID;
	
	@Column(name = "DivisionOffice_ID", nullable = true)
	private int divisionOfficeID;
	
	@Column(name = "Person_ID", nullable = true)
	private int personID;

	public Contact() {
		super();
	}

	public Contact(String data, String contactType, int supplierID, int divisionOfficeID, int personID) {
		super();
		setData(data);
		setContactType(contactType);
		setSupplierID(supplierID);
		setDivisionOfficeID(divisionOfficeID);
		setPersonID(personID);
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
