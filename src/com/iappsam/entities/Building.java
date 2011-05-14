package com.iappsam.entities;

public class Building {
	private int buildingID;
	private String buildingName;
	private String buildingAddress;
	
	private void init(int buildingID, String  buildingName, String buildingAddress){
		this.buildingAddress=buildingAddress;
		this.buildingName=buildingName;
		this.buildingID=buildingID;
	}
	
	public Building(int buildingID, String buildingName){
		init(buildingID, buildingName, "");
	}
	public Building(int buildingID, String buildingName, String buildingAddress){
		init(buildingID, buildingName, buildingAddress);
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getBuildingAddress() {
		return buildingAddress;
	}

	public void setBuildingAddress(String buildingAddress) {
		this.buildingAddress = buildingAddress;
	}
}
