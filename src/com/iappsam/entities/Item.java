package com.iappsam.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_ID")
	private int itemID;
	
	@Column(name = "Name")
	private String name;
	
	@Column (name = "Stock_Number")
	private String stockNumber;
	
	@Column (name = "Unit")
	private String unit;
	
	@Column(name = "Description")
	private String description;
	
	@Column(name = "Price")
	private float price;
	
	@Column (name = "Date_Acquired")
	private Date dateAcquired;
	
	@Column (name = "Inventory_Item_Number")
	private int inventoryItemNumber;
	
	@Column (name = "Property_Number")
	private String propertyNumber;
	
	@Column (name = "Item_Status")
	private String itemStatus;
	
	@Column (name = "Item_Condition")
	private String itemCondition;

	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Item(String name, String stockNumber, String unit, String description, float price, Date dateAcquired, int inventoryItemNumber, String propertyNumber, String itemStatus, String itemCondition) {
		super();
		this.name = name;
		this.stockNumber = stockNumber;
		this.unit = unit;
		this.description = description;
		this.price = price;
		this.dateAcquired = dateAcquired;
		this.inventoryItemNumber = inventoryItemNumber;
		this.propertyNumber = propertyNumber;
		this.itemStatus = itemStatus;
		this.itemCondition = itemCondition;
	}

	public Item(String name, String unit, String description, float price, Date dateAcquired, String itemStatus, String itemCondition) {
		super();
		this.name = name;
		this.unit = unit;
		this.description = description;
		this.price = price;
		this.dateAcquired = dateAcquired;
		this.itemStatus = itemStatus;
		this.itemCondition = itemCondition;
	}

	public int getItemID() {
		return itemID;
	}

	public String getName() {
		return name;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public String getUnit() {
		return unit;
	}

	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}

	public Date getDateAcquired() {
		return dateAcquired;
	}

	public int getInventoryItemNumber() {
		return inventoryItemNumber;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDateAcquired(Date dateAcquired) {
		this.dateAcquired = dateAcquired;
	}

	public void setInventoryItemNumber(int inventoryItemNumber) {
		this.inventoryItemNumber = inventoryItemNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}
	
}
