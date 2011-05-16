package com.iappsam.entities.forms;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InventoryOfEquipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Inventory_Of_Equipment_ID", nullable = false)
	private int ieID;

	@Column(name = "DivisionOffice_ID", nullable = false)
	private int divisionOfficeID;

	@Column(name = "Signatory_ID", nullable = false)
	private int administrativeAssistandID;

	@Column(name = "Signatory_ID1", nullable = false)
	private int supplyOfficeSignatoryID;

	@Column(name = "Signatory_ID4", nullable = false)
	private int deanSignatoryID;

	@Column(name = "Signatory_ID5", nullable = false)
	private int coaRepresentativeSignatoryID;

	@Column(name = "Signatory_ID2", nullable = true)
	private int invnetoryCommiteeMemberSignatoryID;

	@Column(name = "Signator_ID3", nullable = true)
	private int inventoryCommiteeMemberSignatoryID2;

	@Column(name = "Signatory_ID6", nullable = true)
	private int inventoryCommiteeMemberSignatoryID3;

	private void init(int ieID, int divisionOfficeID, int administrativeAssistandID, int supplyOfficeSignatoryID, int deanSignatoryID, int coaRepresentativeSignatoryID, int invnetoryCommiteeMemberSignatoryID, int invnetoryCommiteeMemberSignatoryID2,
			int invnetoryCommiteeMemberSignatoryID3) {
		this.ieID = ieID;
		this.divisionOfficeID = divisionOfficeID;
		this.administrativeAssistandID = administrativeAssistandID;
		this.supplyOfficeSignatoryID = supplyOfficeSignatoryID;
		this.deanSignatoryID = deanSignatoryID;
		this.coaRepresentativeSignatoryID = coaRepresentativeSignatoryID;
		this.invnetoryCommiteeMemberSignatoryID = invnetoryCommiteeMemberSignatoryID;
		this.inventoryCommiteeMemberSignatoryID2 = invnetoryCommiteeMemberSignatoryID2;
		this.inventoryCommiteeMemberSignatoryID3 = invnetoryCommiteeMemberSignatoryID3;
	}

	public InventoryOfEquipment(int ieID, int divisionOfficeID, int administrativeAssistandID, int supplyOfficeSignatoryID, int deanSignatoryID, int coaRepresentativeSignatoryID) {
		init(ieID, divisionOfficeID, administrativeAssistandID, supplyOfficeSignatoryID, deanSignatoryID, coaRepresentativeSignatoryID, -1, -1, -1);
	}

	public InventoryOfEquipment(int ieID, int divisionOfficeID, int administrativeAssistandID, int supplyOfficeSignatoryID, int deanSignatoryID, int coaRepresentativeSignatoryID, int invnetoryCommiteeMemberSignatoryID,
			int invnetoryCommiteeMemberSignatoryID2, int invnetoryCommiteeMemberSignatoryID3) {
		init(ieID, divisionOfficeID, administrativeAssistandID, supplyOfficeSignatoryID, deanSignatoryID, coaRepresentativeSignatoryID, invnetoryCommiteeMemberSignatoryID, invnetoryCommiteeMemberSignatoryID2, invnetoryCommiteeMemberSignatoryID3);
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

	public int[] getSignatories() {
		int[] signatories = { administrativeAssistandID, supplyOfficeSignatoryID, invnetoryCommiteeMemberSignatoryID, inventoryCommiteeMemberSignatoryID2, deanSignatoryID, coaRepresentativeSignatoryID, inventoryCommiteeMemberSignatoryID3 };
		return signatories;
	}

}
