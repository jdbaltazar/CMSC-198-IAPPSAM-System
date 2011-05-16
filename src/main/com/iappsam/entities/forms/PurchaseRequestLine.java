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
public class PurchaseRequestLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2663270554482089249L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PR_Line_ID")
	private int prLineID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Unit")
	private String unit;

	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Stock_Number")
	private String stockNumber;

	@Column(name = "Estimated_Unit_Cost")
	private float estimatedUnitCost;

	@Id
	@Column(name = "Purchase_Request_ID")
	private int prID;

	public PurchaseRequestLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PurchaseRequestLine(int quantity, String unit, String itemDescription, String stockNumber, float estimatedUnitCost, int prID) {
		super();
		this.quantity = quantity;
		this.unit = unit;
		this.itemDescription = itemDescription;
		this.stockNumber = stockNumber;
		this.estimatedUnitCost = estimatedUnitCost;
		this.prID = prID;
	}

	public PurchaseRequestLine(int quantity, String unit, String itemDescription, int prID) {
		super();
		this.quantity = quantity;
		this.unit = unit;
		this.itemDescription = itemDescription;
		this.prID = prID;
	}

	public int getPrLineID() {
		return prLineID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getUnit() {
		return unit;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public float getEstimatedUnitCost() {
		return estimatedUnitCost;
	}

	public int getPrID() {
		return prID;
	}

	public void setPrLineID(int prLineID) {
		this.prLineID = prLineID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public void setEstimatedUnitCost(float estimatedUnitCost) {
		this.estimatedUnitCost = estimatedUnitCost;
	}

	public void setPrID(int prID) {
		this.prID = prID;
	}

}
