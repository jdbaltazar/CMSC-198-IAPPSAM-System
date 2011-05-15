package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMR_Line")
public class WasteMaterialsReportLine {
	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "OR_Number")
	private String orNumber;

	@Column(name = "Disposal")
	private String disposal;

	@Id
	@Column(name = "Waste_Materials_Report_ID")
	private int wasteMaterialsReportId;

	@Column(name = "Disposed_To")
	private String disposedTo;

	private void init(int itemID, int quantity, String orNumber, String disposal, int wasteMaterialsReportID, String disposedTo) {
		this.wasteMaterialsReportId = wasteMaterialsReportID;
		this.itemID = itemID;
		this.disposal = disposal;
		this.quantity = quantity;
		this.orNumber = orNumber;
		this.disposedTo = disposedTo;
	}

	public WasteMaterialsReportLine(int itemID, int quantity, String orNumber, String disposal, int wasteMaterialsReportID) {
		init(itemID, quantity, orNumber, disposal, wasteMaterialsReportID, "");
	}

	public WasteMaterialsReportLine(int itemID, int quantity, String orNumber, String disposal, int wasteMaterialsReportID, String disposedTo) {
		init(itemID, quantity, orNumber, disposal, wasteMaterialsReportID, disposedTo);
	}

	public WasteMaterialsReportLine() {

	}

	public int getItemID() {
		return itemID;
	}

	public String getDisposal() {
		return disposal;
	}

	public String getDisposedTo() {
		return disposedTo;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setOrNumber(String orNumber) {
		this.orNumber = orNumber;
	}

	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}

	public void setWasteMaterialsReportId(int wasteMaterialsReportId) {
		this.wasteMaterialsReportId = wasteMaterialsReportId;
	}

	public void setDisposedTo(String disposedTo) {
		this.disposedTo = disposedTo;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public String getDisposalDetailID() {
		return disposal;
	}

	public int getWasteMaterialsReportId() {
		return wasteMaterialsReportId;
	}
}
