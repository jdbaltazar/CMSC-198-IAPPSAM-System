package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PR_Line")
public class PurchaseRequestLine implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2663270554482089249L;

	@Column(name = "Quantity")
	private int quantity;

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Estimated_Unit_Cost")
	private long estimatedUnitCost;

	@Id
	@Column(name = "Purchase_Request_ID")
	private int prID;

	public PurchaseRequestLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public PurchaseRequestLine(int quantity, String itemDescription, long estimatedUnitCost, int prID) {
		super();
		this.quantity = quantity;
		this.itemDescription = itemDescription;
		this.estimatedUnitCost = estimatedUnitCost;
		this.prID = prID;
	}

	public PurchaseRequestLine(int quantity, String itemDescription, int prID) {
		super();
		this.quantity = quantity;
		this.itemDescription = itemDescription;
		this.prID = prID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public long getEstimatedUnitCost() {
		return estimatedUnitCost;
	}

	public int getPrID() {
		return prID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setEstimatedUnitCost(long estimatedUnitCost) {
		this.estimatedUnitCost = estimatedUnitCost;
	}

	public void setPrID(int prID) {
		this.prID = prID;
	}
	
}
