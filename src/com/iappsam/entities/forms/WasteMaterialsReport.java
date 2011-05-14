package com.iappsam.entities.forms;

import java.sql.Date;

public class WasteMaterialsReport {
	private int wmrID;
	private int divisionOfficeID;
	private int[] signatoryID;
	private Date wmrDate;

	private String placeOfStorage;

	private void init(int wmrID, int divisionOfficeID, int[] signatoryID,
			Date wmrDate, String placeOfStorage) {
		this.wmrDate = wmrDate;
		this.divisionOfficeID = divisionOfficeID;
		this.signatoryID = signatoryID;
		this.wmrID = wmrID;
		this.placeOfStorage = placeOfStorage;
	}

	public WasteMaterialsReport(int wmrID, int divisionOfficeID,
			int[] signatoryID, Date wmrDate) {
		init(wmrID, divisionOfficeID, signatoryID, wmrDate, "");
	}

	public WasteMaterialsReport(int wmrID, int divisionOfficeID,
			int[] signatoryID, Date wmrDate, String placeOfStorage) {
		init(wmrID, divisionOfficeID, signatoryID, wmrDate, placeOfStorage);
	}

	public String getPlaceOfStorage() {
		return placeOfStorage;
	}

	public void setPlaceOfStorage(String placeOfStorage) {
		this.placeOfStorage = placeOfStorage;
	}

	public int getWmrID() {
		return wmrID;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

	public Date getWmrDate() {
		return wmrDate;
	}
}
