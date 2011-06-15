package com.iappsam.forms;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RSMI {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RSMI_ID")
	private int rsmiID;

	@Column(name = "Date")
	private Date rsmiDate;

	@Column(name = "rsmiNumber")
	private int rsmiNumber;

	@Column(name = "Signatory_ID")
	private int supplyOfficeSignatoryID;

	@Column(name = "Signatory_ID1")
	private int accountingClerkSignatoryID;

	public RSMI(int rsmiID, Date rsmiDate, int rsmiNumber, int supplyOfficerSignatoryID, int accountingClerkSignatoryID) {
		this.rsmiDate = rsmiDate;
		this.rsmiID = rsmiID;
		this.rsmiNumber = rsmiNumber;
		this.supplyOfficeSignatoryID = supplyOfficerSignatoryID;
		this.accountingClerkSignatoryID = accountingClerkSignatoryID;
	}

	public int getSupplyOfficeSignatoryID() {
		return supplyOfficeSignatoryID;
	}

	public int getAccountingClerkSignatoryID() {
		return accountingClerkSignatoryID;
	}

	public void setRsmiID(int rsmiID) {
		this.rsmiID = rsmiID;
	}

	public void setRsmiDate(Date rsmiDate) {
		this.rsmiDate = rsmiDate;
	}

	public void setRsmiNumber(int rsmiNumber) {
		this.rsmiNumber = rsmiNumber;
	}

	public void setSupplyOfficeSignatoryID(int supplyOfficeSignatoryID) {
		this.supplyOfficeSignatoryID = supplyOfficeSignatoryID;
	}

	public void setAccountingClerkSignatoryID(int accountingClerkSignatoryID) {
		this.accountingClerkSignatoryID = accountingClerkSignatoryID;
	}

	public int getRsmiID() {
		return rsmiID;
	}

	public Date getRsmiDate() {
		return rsmiDate;
	}

	public int getRsmiNumber() {
		return rsmiNumber;
	}

	public int[] getSignatoryID() {
		int[] signatories = { supplyOfficeSignatoryID, accountingClerkSignatoryID };
		return signatories;
	}
}
