package com.iappsam.entities.forms;

import java.sql.Date;

public class RSMI {
	private int rsmiID;
	private Date rsmiDate;
	private int rsmiNumber;
	private int[] signatoryID;

	public RSMI(int rsmiID, Date rsmiDate, int rsmiNumber, int[] signatoryID) {
		this.rsmiDate = rsmiDate;
		this.rsmiID = rsmiID;
		this.rsmiNumber = rsmiNumber;
		this.signatoryID = signatoryID;
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
		return signatoryID;
	}
}
