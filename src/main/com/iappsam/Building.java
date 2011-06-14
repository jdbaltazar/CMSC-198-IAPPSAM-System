package com.iappsam;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Building {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Building_ID")
	private int buildingID;
	
	@Column(name = "Name")
	private String buildingName;
	
	@Column(name = "Address")
	private String buildingAddress;

	public Building() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Building(String buildingName, String buildingAddress) {
		super();
		this.buildingName = buildingName;
		this.buildingAddress = buildingAddress;
	}

	public int getID() {
		return buildingID;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}	
	
}
