package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAR")
public class PropertyAcknowledgementReceipt {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PAR_ID")
	private int parID;

	@Column(name = "Supplier_ID")
	private int supplierID;

	@Column(name = "Signatory_ID")
	private int recievedBySignatoryID;

	@Column(name = "Signatory_ID1")
	private int recievedFromSignatoryID;

	private void init(int parID, int supplierID, int recievedBySignatoryID, int recievedFromSignatoryID) {
		this.parID = parID;
		this.supplierID = supplierID;
		this.recievedBySignatoryID = recievedBySignatoryID;
		this.recievedFromSignatoryID = recievedFromSignatoryID;
	}

	public PropertyAcknowledgementReceipt(int parID, int supplierID, int recievedBySignatoryID, int recievedFromSignatoryID2) {
		init(parID, supplierID, recievedBySignatoryID, recievedFromSignatoryID2);

	}

	public int getParID() {
		return parID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public int[] getSignatoryID() {
		int[] signatories = { recievedBySignatoryID, recievedFromSignatoryID };
		return signatories;
	}

}
