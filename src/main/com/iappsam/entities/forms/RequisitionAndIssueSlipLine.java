package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Id;

public class RequisitionAndIssueSlipLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7888860671840670652L;
	
	@Id
	@Column(name = "Item_ID")
	private int itemID;
	
	@Column(name = "Quantity_Requested")
	private int quantityRequested;
	
	@Column(name = "Quantity_Issued")
	private int quantityIssued;
	
	@Column(name ="Remarks")
	private String remarks;
	
	@Id
	@Column(name = "RIS_Number")
	private int risNumber;

	public RequisitionAndIssueSlipLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequisitionAndIssueSlipLine(int itemID, int quantityRequested, int quantityIssued, String remarks, int risNumber) {
		super();
		this.itemID = itemID;
		this.quantityRequested = quantityRequested;
		this.quantityIssued = quantityIssued;
		this.remarks = remarks;
		this.risNumber = risNumber;
	}

	public RequisitionAndIssueSlipLine(int itemID, int quantityRequested, int quantityIssued, int risNumber) {
		super();
		this.itemID = itemID;
		this.quantityRequested = quantityRequested;
		this.quantityIssued = quantityIssued;
		this.risNumber = risNumber;
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

	public String getRemarks() {
		return remarks;
	}

	public int getRisNumber() {
		return risNumber;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setQuantityRequested(int quantityRequested) {
		this.quantityRequested = quantityRequested;
	}

	public void setQuantityIssued(int quantityIssued) {
		this.quantityIssued = quantityIssued;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setRisNumber(int risNumber) {
		this.risNumber = risNumber;
	}
	
}
