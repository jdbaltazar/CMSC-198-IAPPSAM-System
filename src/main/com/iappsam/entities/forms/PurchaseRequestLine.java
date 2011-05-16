package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PR_Line")
public class PurchaseRequestLine {
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

	private void init(int prLineID, int quantity, String unit, String itemDescription, int prID, String stockNumber, float estimatedUnitCost) {
		this.prLineID = prLineID;
		this.quantity = quantity;
		this.unit = unit;
		this.itemDescription = itemDescription;
		this.prID = prID;
		this.stockNumber = stockNumber;
		this.estimatedUnitCost = estimatedUnitCost;
	}

	public PurchaseRequestLine(int prLineID, int quantity, String unit, String itemDescription, int prID) {
		init(prLineID, quantity, unit, itemDescription, prID, "", -0.1f);
	}

	public PurchaseRequestLine(int prLineID, int quantity, String unit, String itemDescription, int prID, String stockNumber, float estimatedUnitCost) {
		init(prLineID, quantity, unit, itemDescription, prID, stockNumber, estimatedUnitCost);
	}

	public PurchaseRequestLine() {

	}

	public int getPrLineID() {
		return prLineID;
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

	public void setPrID(int prID) {
		this.prID = prID;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public float getEstimatedUnitCost() {
		return estimatedUnitCost;
	}

	public void setEstimatedUnitCost(float estimatedUnitCost) {
		this.estimatedUnitCost = estimatedUnitCost;
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

	public int getPrID() {
		return prID;
	}

}
