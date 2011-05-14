package com.iappsam.entities.forms;

import java.sql.Date;

public class IIRUP {
	private int iirupID;
	private Date asOfDate;
	private int employeeID;
	private int[] signatoryID;

	private String station;

	private void init(int iirupID, Date asOfDate, int employeeID,
			int[] signatoryID, String station) {
		this.iirupID = iirupID;
		this.asOfDate = asOfDate;
		this.employeeID = employeeID;
		this.signatoryID = signatoryID;
		this.station = station;
	}

	public IIRUP(int iirupID, Date asOfDate, int employeeID, int[] signatoryID) {
		init(iirupID, asOfDate, employeeID, signatoryID, "");
	}

	public IIRUP(int iirupID, Date asOfDate, int employeeID, int[] signatoryID,
			String station) {
		init(iirupID, asOfDate, employeeID, signatoryID, station);
	}

	public String getStation() {
		return station;
	}

	public void setStation(String station) {
		this.station = station;
	}

	public int getIirupID() {
		return iirupID;
	}

	public Date getAsOfDate() {
		return asOfDate;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}
}
