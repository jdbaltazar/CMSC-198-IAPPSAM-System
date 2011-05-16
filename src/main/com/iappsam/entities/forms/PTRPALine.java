package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PTRPA_Line")
public class PTRPALine {
	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "ARE_MR_Number")
	private String areMRNumber;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Remarks")
	private String remarks;

	@Id
	@Column(name = "PTRPA_ID")
	private int ptrpaID;

	private void init(int itemID, String areMRNumber, int quantity, String remarks, int ptrpaID) {
		this.itemID = itemID;
		this.areMRNumber = areMRNumber;
		this.quantity = quantity;
		this.remarks = remarks;
		this.ptrpaID = ptrpaID;
	}

	public PTRPALine(int itemID, String areMRNumber, int quantity, String remarks, int ptrpaID) {
		init(itemID, areMRNumber, quantity, remarks, ptrpaID);
	}

	public PTRPALine(int itemID, int quantity, int ptrpaID) {
		init(itemID, "", quantity, "", ptrpaID);

	}

	public int getItemID() {
		return itemID;
	}

	public String getAreMRNumber() {
		return areMRNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getPtrpaID() {
		return ptrpaID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setAreMRNumber(String areMRNumber) {
		this.areMRNumber = areMRNumber;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setPtrpaID(int ptrpaID) {
		this.ptrpaID = ptrpaID;
	}
}
