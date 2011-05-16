package com.iappsam.entities.forms;

import java.io.Serializable;

public class RequisitionAndIssueSlipLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7888860671840670652L;
	private int itemID;
	private int quantityRequested;
	private int quantityIssued;
	private int risNumber;

	private String remarks;

	private void init(int risLineID, int itemID, int quantityRequested,
			int quantityIssued, int risNumber, String remarks) {
		this.remarks = remarks;
		this.itemID = itemID;
		this.risNumber = risNumber;
		this.quantityIssued = quantityIssued;
		this.quantityRequested = quantityRequested;
	}

	public RequisitionAndIssueSlipLine(int risLineID, int itemID,
			int quantityRequested, int quantityIssued, int risNumber) {
		init(risLineID, itemID, quantityRequested, quantityIssued, risNumber,
				"");
	}

	public RequisitionAndIssueSlipLine(int risLineID, int itemID,
			int quantityRequested, int quantityIssued, int risNumber,
			String remarks) {
		init(risLineID, itemID, quantityRequested, quantityIssued, risNumber,
				remarks);
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	public int getItemID() {
		return itemID;
	}

	public int getQuantityRequested() {
		return quantityRequested;
	}

	public int getQuantityIssued() {
		return quantityIssued;
	}

	public int getRisNumber() {
		return risNumber;
	}
}
