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
	@Column(name = "Item_Description")
	private String itemDescription;

	@Id
	@Column(name = "PO_Number")
	private String poNumber;

	public PurchaseOrderLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseOrderLine(String itemDescription, String poNumber) {
		super();
		this.itemDescription = itemDescription;
		this.poNumber = poNumber;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getPoNumber() {
		return poNumber;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}

}
