package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class DivisionOffice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;
	
	@Column(name = "Division")
	private String divisionName;
	
	@Column(name = "Office")
	private String officeName;

	public DivisionOffice() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DivisionOffice(String divisionName, String officeName) {
		super();
		this.divisionName = divisionName;
		this.officeName = officeName;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public String getDivisionName() {
		return divisionName;
	}

	public String getOfficeName() {
		return officeName;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setDivisionName(String divisionName) {
		this.divisionName = divisionName;
	}

	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
		
}
