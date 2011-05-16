package com.iappsam.entities.forms;

import java.sql.Date;

public class RequisitionAndIssueSlip {
	private int divisionOfficeID;
	private int risNumber;
	private Date risDate;
	private String purpose;
	private int[] signatoryID;

	private String rcCode;
	private String saiNumber;
	private Date saiDate;

	private void init(int divisionOfficeID, int risNumber, Date risDate,
			String purpose, int[] signatoryID, String rcCode, String saiNumber,
			Date saiDate) {
		this.divisionOfficeID = divisionOfficeID;
		this.risNumber = risNumber;
		this.risDate = risDate;
		this.purpose = purpose;
		this.signatoryID = signatoryID;

		this.rcCode = rcCode;
		this.saiNumber = saiNumber;
		this.saiDate = saiDate;
	}

	public RequisitionAndIssueSlip(int divisionOfficeID, int risNumber,
			Date risDate, String purpose, int[] signatoryID, String rcCode,
			String saiNumber, Date saiDate) {
		init(divisionOfficeID, risNumber, risDate, purpose, signatoryID,
				rcCode, saiNumber, saiDate);
	}

	public RequisitionAndIssueSlip(int divisionOfficeID, int risNumber,
			Date risDate, String purpose, int[] signatoryID) {
		init(divisionOfficeID, risNumber, risDate, purpose, signatoryID, "",
				"", null);
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getSaiNumber() {
		return saiNumber;
	}

	public void setSaiNumber(String saiNumber) {
		this.saiNumber = saiNumber;
	}

	public Date getSaiDate() {
		return saiDate;
	}

	public void setSaiDate(Date saiDate) {
		this.saiDate = saiDate;
	}

	public int getDivisionOfficeID() {
		return divisionOfficeID;
	}

	public int getRisNumber() {
		return risNumber;
	}

	public Date getRisDate() {
		return risDate;
	}

	public int[] getSignatoryID() {
		return signatoryID;
	}

	public String getRcCode() {
		return rcCode;
	}
}
