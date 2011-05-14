package com.iappsam.entities.forms;

public class PurchaseRequestLine {
	private int prLineID;
	private int quantity;
	private String unit;
	private String itemDescription;
	private int prID;
	private String stockNumber;
	private float estimatedUnitCost;

	private void init(int prLineID, int quantity, String unit,
			String itemDescription, int prID, String stockNumber,
			float estimatedUnitCost) {
		this.prLineID = prLineID;
		this.quantity = quantity;
		this.unit = unit;
		this.itemDescription = itemDescription;
		this.prID = prID;
		this.stockNumber = stockNumber;
		this.estimatedUnitCost = estimatedUnitCost;
	}

	public PurchaseRequestLine(int prLineID, int quantity, String unit,
			String itemDescription, int prID) {
		init(prLineID, quantity, unit, itemDescription, prID, "", -0.1f);
	}

	public PurchaseRequestLine(int prLineID, int quantity, String unit,
			String itemDescription, int prID, String stockNumber,
			float estimatedUnitCost) {
		init(prLineID, quantity, unit, itemDescription, prID, stockNumber,
				estimatedUnitCost);
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

	public int getPrID() {
		return prID;
	}

}
