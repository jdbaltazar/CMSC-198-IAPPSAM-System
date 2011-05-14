package com.iappsam.entities.forms;

import java.sql.Date;

public class PurchaseRequest {
	// Not Null
	private int prID;
	private int divisionOfficeID;
	private String purpose;
	private int[] signatoryID;

	// Null
	private String prNumber;
	private String saiNumber;
	private String alobsNumber;
	private Date prDate;
	private Date saiDate;
	private Date alobsDate;

	private void init(int prID, int divisionOfficeID, String purpose,
			int[] signatoryID, String prNumber, String saiNumber,
			String alobsNumber, Date prDate, Date saiDate, Date alobsDate) {
		this.prID = prID;
		this.divisionOfficeID = divisionOfficeID;
		this.purpose = purpose;
		this.signatoryID = signatoryID;
		this.prNumber = prNumber;
		this.saiNumber = saiNumber;
		this.alobsNumber = alobsNumber;
		this.prDate = prDate;
		this.saiDate = saiDate;
		this.alobsDate = alobsDate;
	}

	public PurchaseRequest(int prID, int divisionOfficeID, String purpose,
			int[] signatoryID) {
		init(prID, divisionOfficeID, purpose, signatoryID, "", "", "", null,
				null, null);
	}

	public PurchaseRequest(int prID, int divisionOfficeID, String purpose,
			int[] signatoryID, String prNumber, String saiNumber,
			String alobsNumber, Date prDate, Date saiDate, Date alobsDate) {
		init(prID, divisionOfficeID, purpose, signatoryID, prNumber, saiNumber,
				alobsNumber, prDate, saiDate, alobsDate);
	}

	public String getPrNumber() {
		return prNumber;
	}

	public void setPrNumber(String prNumber) {
		this.prNumber = prNumber;
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public String getAlobsNumber() {
		return alobsNumber;
	}

	public void setAlobsNumber(String alobsNumber) {
		this.alobsNumber = alobsNumber;
	}

	public Date getPrDate() {
		return prDate;
	}

	public void setPrDate(Date prDate) {
		this.prDate = prDate;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public Date getAlobsDate() {
		return alobsDate;
	}

	public void setAlobsDate(Date alobsDate) {
		this.alobsDate = alobsDate;
	}

	public int getPrID() {
		return prID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public String getPurpose() {
		return purpose;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}
}
