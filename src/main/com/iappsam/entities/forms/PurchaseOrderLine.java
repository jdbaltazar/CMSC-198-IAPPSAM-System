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
	@Column(name = "Item_ID")
	private int itemID;

	@Id
	@Column(name = "PO_Number")
	private String poNumber;

	public PurchaseOrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderLine(int itemID, String poNumber) {
		super();
		this.itemID = itemID;
		this.poNumber = poNumber;
	}

	public int getItemID() {
		return itemID;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

}
