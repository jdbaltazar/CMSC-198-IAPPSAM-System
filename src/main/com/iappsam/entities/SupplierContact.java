package com.iappsam.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Supplier_Contact")
public class SupplierContact implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7606573609721366176L;

	@Id
	@Column(name = "Person_ID")
	private int supplierID;
	
	@Id
	@Column(name = "Person_ID")
	private int contactID;

	public SupplierContact() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SupplierContact(int supplierID, int contactID) {
		super();
		this.supplierID = supplierID;
		this.contactID = contactID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public int getContactID() {
		return contactID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setContactID(int contactID) {
		this.contactID = contactID;
	}

}
