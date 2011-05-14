package com.iappsam.entities.forms;

import java.sql.Date;


public class Item {
	
	
	private int itemID;
	private String itemName;
	private String unit;
	private String itemDescription;
	private float price;
	private Date dateAcquired;
	private String itemStatus;
	private String itemCondition;

	private String stockNumber;
	private String inventoryItemNumber;
	private String propertyNumber;

	private void init(int itemID, String itemName, String unit,
			String itemDescription, float price, Date dateAcquired,
			String itemStatus, String itemCondition, String stockNumber,
			String inventoryItemNumber, String propertyNumber) {
		this.itemID = itemID;
		this.itemName = itemName;
		this.unit = unit;
		this.itemDescription = itemDescription;
		this.price = price;
		this.dateAcquired = dateAcquired;
		this.itemStatus = itemStatus;
		this.itemCondition = itemCondition;
		this.stockNumber = stockNumber;
		this.inventoryItemNumber = inventoryItemNumber;
		this.propertyNumber = propertyNumber;

	}

	public Item(int itemID, String itemName, String unit, String itemDescription,
			float price, Date dateAcquired, String itemStatus,
			String itemCondition, String stockNumber,
			String inventoryItemNumber, String propertyNumber) {
		init(itemID, itemName, unit, itemDescription, price, dateAcquired,
				itemStatus, itemCondition, stockNumber, inventoryItemNumber,
				propertyNumber);
	}

	public Item(int itemID, String itemName, String unit, String itemDescription,
			float price, Date dateAcquired, String itemStatus,
			String itemCondition) {
		init(itemID, itemName, unit, itemDescription, price, dateAcquired,
				itemStatus, itemCondition, "", "", "");

	}

	public String getStockNumber() {
		return stockNumber;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public String getInventoryItemNumber() {
		return inventoryItemNumber;
	}

	public void setInventoryItemNumber(String inventoryItemNumber) {
		this.inventoryItemNumber = inventoryItemNumber;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public int getItemID() {
		return itemID;
	}

	public String getItemName() {
		return itemName;
	}

	public String getUnit() {
		return unit;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public float getPrice() {
		return price;
	}

	public Date getDateAcquired() {
		return dateAcquired;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public String getItemCondition() {
		return itemCondition;
	}
}
