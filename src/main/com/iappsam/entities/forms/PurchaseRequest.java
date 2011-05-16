package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Purchase_Request")
public class PurchaseRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Purchase_Request_ID")
	private int prID;

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;

	@Column(name = "PR_Number")
	private String prNumber;

	@Column(name = "PR_Date")
	private Date prDate;

	@Column(name = "SAI_Number")
	private String saiNumber;
	@Column(name = "SAI_Date")
	private Date saiDate;

	@Column(name = "ALOBS_Number")
	private String alobsNumber;
	@Column(name = "ALOBS_DATE")
	private Date alobsDate;

	@Column(name = "Purpose")
	private String purpose;
	
	@Column(name = "Signatory_ID")
	private int requestedBySignatoryID;
	
	@Column(name = "Signatory_ID1")
	private int approvedBySignatoryID;

	public PurchaseRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseRequest(int divisionOfficeID, String prNumber, Date prDate, String saiNumber, Date saiDate, String alobsNumber, Date alobsDate, String purpose, int requestedBySignatoryID, int approvedBySignatoryID) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.prNumber = prNumber;
		this.prDate = prDate;
		this.saiNumber = saiNumber;
		this.saiDate = saiDate;
		this.alobsNumber = alobsNumber;
		this.alobsDate = alobsDate;
		this.purpose = purpose;
		this.requestedBySignatoryID = requestedBySignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
	}

	public PurchaseRequest(int divisionOfficeID, String purpose, int requestedBySignatoryID, int approvedBySignatoryID) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.purpose = purpose;
		this.requestedBySignatoryID = requestedBySignatoryID;
		this.approvedBySignatoryID = approvedBySignatoryID;
	}

	public int getPrID() {
		return prID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public String getPrNumber() {
		return prNumber;
	}

	public Date getPrDate() {
		return prDate;
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public String getAlobsNumber() {
		return alobsNumber;
	}

	public Date getAlobsDate() {
		return alobsDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public int getRequestedBySignatoryID() {
		return requestedBySignatoryID;
	}

	public int getApprovedBySignatoryID() {
		return approvedBySignatoryID;
	}

	public void setPrID(int prID) {
		this.prID = prID;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public void setAlobsNumber(String alobsNumber) {
		this.alobsNumber = alobsNumber;
	}

	public void setAlobsDate(Date alobsDate) {
		this.alobsDate = alobsDate;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setRequestedBySignatoryID(int requestedBySignatoryID) {
		this.requestedBySignatoryID = requestedBySignatoryID;
	}

	public void setApprovedBySignatoryID(int approvedBySignatoryID) {
		this.approvedBySignatoryID = approvedBySignatoryID;
	}

	
}
