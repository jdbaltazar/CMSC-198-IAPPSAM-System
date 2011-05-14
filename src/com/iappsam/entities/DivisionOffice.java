package com.iappsam.entities;

public class DivisionOffice {
	private int divisionOfficeID;
	private int buildingID;
	private String divisionName;
	private String officeName;
	
	private void init(int divisionOfficeID, int buildingID, String divisionName,String officeName){
		this.divisionName=divisionName;
		this.divisionOfficeID=divisionOfficeID;
		this.buildingID=buildingID;
		this.officeName=officeName;
	}
	
	public DivisionOffice(int divisionOfficeID, int buildingID, String divisionName,String officeName){
		init(divisionOfficeID, buildingID, divisionName, officeName);
	}
	
	public DivisionOffice(int divisionOfficeID, int buildingID, String divisionName){
		init(divisionOfficeID, buildingID, divisionName, "");
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public int getBuildingID() {
		return buildingID;
	}

	public void setBuildingID(int buildingID) {
		this.buildingID = buildingID;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	
}
