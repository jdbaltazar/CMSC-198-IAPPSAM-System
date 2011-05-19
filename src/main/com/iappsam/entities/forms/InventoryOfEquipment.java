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
	
	@Column(name = "Building_ID")
	private int buildingID;

	public InventoryOfEquipment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryOfEquipment(int ieID, int divisionOfficeID, int buildingID) {
		super();
		this.ieID = ieID;
		this.divisionOfficeID = divisionOfficeID;
		this.buildingID = buildingID;
	}

	public int getIeID() {
		return ieID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

}
