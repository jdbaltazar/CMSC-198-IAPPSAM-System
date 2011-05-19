package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WMR_Line")
public class WasteMaterialsReportLine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -918675709541879390L;

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "OR_Number")
	private String orNumber;

	@Column(name = "Disposal")
	private String disposal;

	@Column(name = "Disposed_To")
	private String disposedTo;

	@Id
	@Column(name = "Waste_Materials_Report_ID")
	private int wasteMaterialsReportId;

	public WasteMaterialsReportLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WasteMaterialsReportLine(String itemDescription, int quantity, String orNumber, String disposal, String disposedTo, int wasteMaterialsReportId) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.orNumber = orNumber;
		this.disposal = disposal;
		this.disposedTo = disposedTo;
		this.wasteMaterialsReportId = wasteMaterialsReportId;
	}

	public WasteMaterialsReportLine(String itemDescription, int quantity, String orNumber, String disposal, int wasteMaterialsReportId) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.orNumber = orNumber;
		this.disposal = disposal;
		this.wasteMaterialsReportId = wasteMaterialsReportId;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getOrNumber() {
		return orNumber;
	}

	public String getDisposal() {
		return disposal;
	}

	public String getDisposedTo() {
		return disposedTo;
	}

	public int getWasteMaterialsReportId() {
		return wasteMaterialsReportId;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
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

	public void setDisposedTo(String disposedTo) {
		this.disposedTo = disposedTo;
	}

	public void setWasteMaterialsReportId(int wasteMaterialsReportId) {
		this.wasteMaterialsReportId = wasteMaterialsReportId;
	}
	
}
