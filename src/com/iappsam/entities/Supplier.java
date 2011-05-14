package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Supplier {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Supplier_ID")
	private int supplierID;
	
	@Column(name = "Name")
	private String supplierName;
	
	@Column(name = "Address")
	private String address;
	
	@Column (name = "TIN")
	private String tin;
	
	@Column(name = "Contact_Person_ID")
	private int contactPersonID;

	public Supplier() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Supplier(String supplierName, String address, String tin, int contactPersonID) {
		super();
		this.supplierName = supplierName;
		this.address = address;
		this.tin = tin;
		this.contactPersonID = contactPersonID;
	}

	public Supplier(String supplierName, String address, int contactPersonID) {
		super();
		this.supplierName = supplierName;
		this.address = address;
		this.contactPersonID = contactPersonID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public String getAddress() {
		return address;
	}

	public String getTin() {
		return tin;
	}

	public int getContactPersonID() {
		return contactPersonID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setTin(String tin) {
		this.tin = tin;
	}

	public void setContactPersonID(int contactPersonID) {
		this.contactPersonID = contactPersonID;
	}

}
