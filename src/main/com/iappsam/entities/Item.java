package com.iappsam.entities;

import java.util.Date;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Resolution;

@Entity
@Indexed
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_ID")
	private int itemID;

	@Field(name = "description")
	@Column(name = "Description")
	private String description;

	@Column(name = "Stock_Number")
	private String stockNumber;

	@Column(name = "Item_Category")
	private String itemCategory;

	@Column(name = "Unit")
	private String unit;

	@Column(name = "Price")
	private float price;

	@Field(name = "date")
	@DateBridge(resolution = Resolution.DAY)
	@Column(name = "Date_Acquired")
	private Date dateAcquired;

	@Column(name = "Inventory_Item_Number")
	private int inventoryItemNumber;

	@Column(name = "Property_Number")
	private String propertyNumber;

	@Column(name = "Item_Status")
	private String itemStatus;

	@Column(name = "Item_Condition")
	private String itemCondition;

	public Item() {
		super();
	}

	public Item(String description, String stockNumber, String itemCategory,
			String unit, float price, Date dateAcquired,
			int inventoryItemNumber, String propertyNumber, String itemStatus,
			String itemCondition) {
		super();
		this.description = description;
		this.stockNumber = stockNumber;
		this.itemCategory = itemCategory;
		this.unit = unit;
		this.price = price;
		this.dateAcquired = dateAcquired;
		this.inventoryItemNumber = inventoryItemNumber;
		this.propertyNumber = propertyNumber;
		this.itemStatus = itemStatus;
		this.itemCondition = itemCondition;
	}

	public Item(String description, String itemCategory, String unit,
			String itemStatus, String itemCondition) {
		super();
		this.description = description;
		this.itemCategory = itemCategory;
		this.unit = unit;
		this.itemStatus = itemStatus;
		this.itemCondition = itemCondition;
	}

	public String getDescription() {
		return description;
	}

	public String getStockNumber() {
		return stockNumber;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public String getUnit() {
		return unit;
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

	public void setDescription(String description) {
		this.description = description;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setUnit(String unit) {
		this.unit = unit;
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

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}
}
