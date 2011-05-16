package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ICS")
public class InventoryCustodianSlip {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ICS_ID", nullable = false)
	private int icsID;
	
	@Column(name = "ICS_Number", nullable = true, length = 45)
	private String icsNumber;
	
	@Column(name = "Purpose", nullable = true, length = 200)
	private String purpose;
	
	@Column(name = "Supplier_ID", nullable = false)
	private int supplierID;
	
	@Column(name = "Signatory_ID", nullable = false)
	private int receivedBySignatoryID;
	
	@Column(name = "Signatory_ID1", nullable = false)
	private int receviedFromSignatoryID;

	public InventoryCustodianSlip() {
		super();
	}

	public InventoryCustodianSlip(String icsNumber, String purpose, int supplierID, int receivedBySignatoryID, int receviedFromSignatoryID) {
		super();
		setIcsNumber(icsNumber);
		setPurpose(purpose);
		setSupplierID(supplierID);
		setReceivedBySignatoryID(receivedBySignatoryID);
		setReceviedFromSignatoryID(receviedFromSignatoryID);
	}

	public InventoryCustodianSlip(int supplierID, int receivedBySignatoryID, int receviedFromSignatoryID) {
		super();
		setSupplierID(supplierID);
		setReceivedBySignatoryID(receivedBySignatoryID);
		setReceviedFromSignatoryID(receviedFromSignatoryID);
	}

	public int getIcsID() {
		return icsID;
	}

	public String getIcsNumber() {
		return icsNumber;
	}

	public String getPurpose() {
		return purpose;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public int getReceivedBySignatoryID() {
		return receivedBySignatoryID;
	}

	public int getReceviedFromSignatoryID() {
		return receviedFromSignatoryID;
	}

	public void setIcsID(int icsID) {
		this.icsID = icsID;
	}

	public void setIcsNumber(String icsNumber) {
		this.icsNumber = icsNumber;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setSupplierID(int supplierID) {
		this.supplierID = supplierID;
	}

	public void setReceivedBySignatoryID(int receivedBySignatoryID) {
		this.receivedBySignatoryID = receivedBySignatoryID;
	}

	public void setReceviedFromSignatoryID(int receviedFromSignatoryID) {
		this.receviedFromSignatoryID = receviedFromSignatoryID;
	}

}
