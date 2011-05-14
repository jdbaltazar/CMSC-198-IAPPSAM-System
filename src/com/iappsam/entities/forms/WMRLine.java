package com.iappsam.entities.forms;

public class WMRLine {
	private int wmrLineID;
	private int quantity;
	private String orNumber;
	private String disposalDetailID;
	private int wasteMaterialsReportId;

	public WMRLine(int wmrLineID, int quantity, String orNumber,
			String disposalDetailID, int wasteMaterialsReportID) {
		this.wasteMaterialsReportId = wasteMaterialsReportID;
		this.wmrLineID = wmrLineID;
		this.disposalDetailID = disposalDetailID;
		this.quantity = quantity;
		this.orNumber = orNumber;
	}

	public int getWmrLineID() {
		return wmrLineID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public String getDisposalDetailID() {
		return disposalDetailID;
	}

	public int getWasteMaterialsReportId() {
		return wasteMaterialsReportId;
	}
}
