package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class InventoryOfEquipment {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Inventory_Of_Equipment_ID")
	private int ieID;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	public InventoryOfEquipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryOfEquipment(int ieID, int divisionOfficeID) {
		super();
		this.ieID = ieID;
		this.divisionOfficeID = divisionOfficeID;
	}

	public int getIeID() {
		return ieID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

}
