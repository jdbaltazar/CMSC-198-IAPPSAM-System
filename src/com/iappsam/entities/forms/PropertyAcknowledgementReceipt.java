package com.iappsam.entities.forms;

public class PropertyAcknowledgementReceipt {
	private int parID;
	private int supplierID;
	private int[] signatoryID;

	private void init(int parID, int supplierID, int[] signatoryID) {
		this.parID = parID;
		this.supplierID = supplierID;
		this.signatoryID = signatoryID;
	}

	public PropertyAcknowledgementReceipt(int parID, int supplierID,
			int[] signatoryID) {
		init(parID, supplierID, signatoryID);

	}

	public int getParID() {
		return parID;
	}

	public int getSupplierID() {
		return supplierID;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

}
