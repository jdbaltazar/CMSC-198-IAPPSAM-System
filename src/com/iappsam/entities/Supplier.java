package com.iappsam.entities;

public class Supplier {
	private int supplierID;
	private String supplierName;
	private String supplierAddress;
	private String TIN;
	private int contactPersonID;

	private void init(int supplierID, String supplierName,
			String supplierAddress, String TIN, int contactPersonID) {
		this.supplierID = supplierID;
		this.supplierAddress = supplierAddress;
		this.supplierName = supplierName;
		this.TIN = TIN;
		this.contactPersonID = contactPersonID;
	}


	public Supplier(int supplierID, String supplierName,
			String supplierAddress, int contactPersonID) {
		init(supplierID, supplierName, supplierAddress, "", contactPersonID);
	}
	public Supplier(int supplierID, String supplierName,
			String supplierAddress, String TIN, int contactPersonID){
		init(supplierID, supplierName, supplierAddress, TIN, contactPersonID);
	}

	public int getSupplierID() {
		return supplierID;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getSupplierAddress() {
		return supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getTIN() {
		return TIN;
	}

	public void setTIN(String tIN) {
		TIN = tIN;
	}

	public int getContactPersonID() {
		return contactPersonID;
	}

	public void setContactPersonID(int contactPersonID) {
		this.contactPersonID = contactPersonID;
	}

}
