package com.iappsam.entities.forms;

public class InventoryOfEquipment {
	private int ieID;
	private int divisionOfficeID;
	private int[] signatoryID;

	private void init(int ieID, int divisionOfficeID, int[] signatoryID) {
		this.ieID = ieID;
		this.divisionOfficeID = divisionOfficeID;
		this.signatoryID = signatoryID;
	}

	public InventoryOfEquipment(int ieID, int divisionOfficeID,
			int[] signatoryID) {
		init(ieID, divisionOfficeID, signatoryID);
	}

	public int getIeID() {
		return ieID;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

	public void setSignatoryID(int[] signatoryID) {
		this.signatoryID = signatoryID;
	}
}
