package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
// Inventory and Inspection of Report of Unserviceable Property
public class IIRUP {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IIRUP_ID")
	private int iirupID;

	@Column(name = "As_Of")
	private Date asOfDate;

	@Column(name = "Employee_ID")
	private int accountableOfficerEmployeeID;

	@Column(name = "Station")
	private String station;

	@Column(name = "Signatory_ID")
	private int requstedBySignatoryID;

	@Column(name = "Signatory_ID1")
	private int approvedBySignatoryID;

	@Column(name = "Signatory_ID2")
	private int inspectorSignatoryID;

	@Column(name = "Signatory_ID3")
	private int witnessSignatoryID;

	public IIRUP() {
		super();
	}

	public IIRUP(Date asOfDate, int accountableOfficerEmployeeID, String station, int requstedBySignatoryID, int approvedBySignatoryID, int inspectorSignatoryID, int witnessSignatoryID) {
		super();
		this.asOfDate = asOfDate;
		this.accountableOfficerEmployeeID = accountableOfficerEmployeeID;
		this.station = station;
		this.requstedBySignatoryID = requstedBySignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
		this.inspectorSignatoryID = inspectorSignatoryID;
		this.witnessSignatoryID = witnessSignatoryID;
	}

	public IIRUP(Date asOfDate, int accountableOfficerEmployeeID, int requstedBySignatoryID, int approvedBySignatoryID, int inspectorSignatoryID, int witnessSignatoryID) {
		super();
		this.asOfDate = asOfDate;
		this.accountableOfficerEmployeeID = accountableOfficerEmployeeID;
		this.requstedBySignatoryID = requstedBySignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
		this.inspectorSignatoryID = inspectorSignatoryID;
		this.witnessSignatoryID = witnessSignatoryID;
	}

	public int getIirupID() {
		return iirupID;
	}

	public Date getAsOfDate() {
		return asOfDate;
	}

	public int getAccountableOfficerEmployeeID() {
		return accountableOfficerEmployeeID;
	}

	public String getStation() {
		return station;
	}

	public int getRequstedBySignatoryID() {
		return requstedBySignatoryID;
	}

	public int getApprovedBySignatoryID() {
		return approvedBySignatoryID;
	}

	public int getInspectorSignatoryID() {
		return inspectorSignatoryID;
	}

	public int getWitnessSignatoryID() {
		return witnessSignatoryID;
	}

	public void setIirupID(int iirupID) {
		this.iirupID = iirupID;
	}

	public void setAsOfDate(Date asOfDate) {
		this.asOfDate = asOfDate;
	}

	public void setAccountableOfficerEmployeeID(int accountableOfficerEmployeeID) {
		this.accountableOfficerEmployeeID = accountableOfficerEmployeeID;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public void setRequstedBySignatoryID(int requstedBySignatoryID) {
		this.requstedBySignatoryID = requstedBySignatoryID;
	}

	public void setApprovedBySignatoryID(int approvedBySignatoryID) {
		this.approvedBySignatoryID = approvedBySignatoryID;
	}

	public void setInspectorSignatoryID(int inspectorSignatoryID) {
		this.inspectorSignatoryID = inspectorSignatoryID;
	}

	public void setWitnessSignatoryID(int witnessSignatoryID) {
		this.witnessSignatoryID = witnessSignatoryID;
	}

}
