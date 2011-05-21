package com.iappsam.entities.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Requisition_And_Issue_Slip")
public class RequisitionAndIssueSlip {

	@Column(name = "DivisionOffice_ID")
	private int divisionOfficeID;
	
	@Column(name = "RC_Code")
	private String rcCode;
	
	@Id
	@Column(name = "RIS_Number")
	private String risNumber;
	
	@Column(name = "RIS_Date")
	private Date risDate;
	
	@Column(name = "SAI_Number")
	private String saiNumber;
	
	@Column(name = "SAI_Date")
	private Date saiDate;
	
	@Column(name = "Purpose")
	private String purpose;
	
	@Column(name = "Signatory_ID")
	private int signatoryID;
	
	@Column(name = "Signatory_ID1")
	private int signatoryID1;
	
	@Column(name = "Signatory_ID2")
	private int signatoryID2;
	
	@Column(name = "Signatory_ID3")
	private int signatoryID3;

	public RequisitionAndIssueSlip() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequisitionAndIssueSlip(int divisionOfficeID, String rcCode, String risNumber, Date risDate, String saiNumber, Date saiDate, String purpose, int signatoryID, int signatoryID1, int signatoryID2, int signatoryID3) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.rcCode = rcCode;
		this.risNumber = risNumber;
		this.risDate = risDate;
		this.saiNumber = saiNumber;
		this.saiDate = saiDate;
		this.purpose = purpose;
		this.signatoryID = signatoryID;
		this.signatoryID1 = signatoryID1;
		this.signatoryID2 = signatoryID2;
		this.signatoryID3 = signatoryID3;
	}

	public RequisitionAndIssueSlip(int divisionOfficeID, String risNumber, Date risDate, String purpose, int signatoryID, int signatoryID1, int signatoryID2, int signatoryID3) {
		super();
		this.divisionOfficeID = divisionOfficeID;
		this.risNumber = risNumber;
		this.risDate = risDate;
		this.purpose = purpose;
		this.signatoryID = signatoryID;
		this.signatoryID1 = signatoryID1;
		this.signatoryID2 = signatoryID2;
		this.signatoryID3 = signatoryID3;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public String getRcCode() {
		return rcCode;
	}

	public String getRisNumber() {
		return risNumber;
	}

	public Date getRisDate() {
		return risDate;
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public String getPurpose() {
		return purpose;
	}

	public int getSignatoryID() {
		return signatoryID;
	}

	public int getSignatoryID1() {
		return signatoryID1;
	}

	public int getSignatoryID2() {
		return signatoryID2;
	}

	public int getSignatoryID3() {
		return signatoryID3;
	}

	public void setDivisionOfficeID(int divisionOfficeID) {
		this.divisionOfficeID = divisionOfficeID;
	}

	public void setRcCode(String rcCode) {
		this.rcCode = rcCode;
	}

	public void setRisNumber(String risNumber) {
		this.risNumber = risNumber;
	}

	public void setRisDate(Date risDate) {
		this.risDate = risDate;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public void setSignatoryID(int signatoryID) {
		this.signatoryID = signatoryID;
	}

	public void setSignatoryID1(int signatoryID1) {
		this.signatoryID1 = signatoryID1;
	}

	public void setSignatoryID2(int signatoryID2) {
		this.signatoryID2 = signatoryID2;
	}

	public void setSignatoryID3(int signatoryID3) {
		this.signatoryID3 = signatoryID3;
	}
}
