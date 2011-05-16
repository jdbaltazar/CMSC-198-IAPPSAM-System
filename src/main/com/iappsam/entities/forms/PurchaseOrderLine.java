package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PO_Line")
public class PurchaseOrderLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7312439919136440157L;

	@Id
	@Column(name = "PO_Number")
	private String poNumber;

	@Id
	@Column(name = "Item_ID")
	private int itemID;

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public PurchaseOrderLine(String poNumber, int itemID) {
		this.poNumber = poNumber;
		this.itemID = itemID;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public int getItemID() {
		return itemID;
	}

}
