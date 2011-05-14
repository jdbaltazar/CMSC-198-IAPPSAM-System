package com.iappsam.entities.forms;

public class AnnualProcurementPlan {
	private int appID;
	private int year;
	private int[] signatoryID;
	private String planControlNumber;
	private String dateScheduled;

	private void init(int appID, int year, int[] signatoryID,
			String planControlNumber, String dateScheduled) {
		this.appID = appID;
		this.year = year;
		this.signatoryID = signatoryID;
		this.planControlNumber = planControlNumber;
		this.dateScheduled = dateScheduled;
	}

	public AnnualProcurementPlan(int appID, int year, int[] signatoryID) {
		init(appID, year, signatoryID, "", "");

	}

	public AnnualProcurementPlan(int appID, int year, int[] signatoryID,
			String planControlNumber, String dateSchedulred) {
		init(appID, year, signatoryID, planControlNumber, dateSchedulred);
	}

	

	public int getAppID() {
		return appID;
	}

	public void setAppID(int appID) {
		this.appID = appID;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

	public void setSignatoryID(int[] signatoryID) {
		this.signatoryID = signatoryID;
	}

	public String getPlanControlNumber() {
		return planControlNumber;
	}

	public void setPlanControlNumber(String planControlNumber) {
		this.planControlNumber = planControlNumber;
	}

	public String getDateScheduled() {
		return dateScheduled;
	}

	public void setDateScheduled(String dateScheduled) {
		this.dateScheduled = dateScheduled;
	}
}
