package com.iappsam.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import jxl.StringFormulaCell;

import org.apache.commons.lang.NullArgumentException;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

@Entity
@Indexed
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Item_ID")
	private int id;

	@Field(name = "description")
	@Column(name = "Description")
	private String description;

	@Column(name = "Stock_Number")
	private String stockNumber;

	@Column(name = "Price")
	private float price;

	@Field(name = "date")
	@DateBridge(resolution = Resolution.DAY)
	@Column(name = "Date_Acquired")
	private Date dateAcquired;

	@Column(name = "Inventory_Item_Number")
	private String inventoryItemNumber;

	@Column(name = "Property_Number")
	private String propertyNumber;

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Unit_ID")
	private Unit unit;

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Item_Status_ID")
	private ItemStatus itemStatus;

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Item_Condition_ID")
	private ItemCondition itemCondition;

	@IndexedEmbedded
	@ManyToOne
	@JoinColumn(name = "Item_Category_ID")
	private ItemCategory itemCategory;

	public Item() {
		super();
	}

	public Item(String description, String stockNumber, ItemCategory itemCategory, Unit unit, float price, Date dateAcquired, String inventoryItemNumber, String propertyNumber, ItemStatus itemStatus,
			ItemCondition itemCondition) {
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

	public Item(String description, ItemCategory itemCategory, Unit unit, ItemStatus itemStatus, ItemCondition itemCondition) {
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

	public Unit getUnit() {
		return unit;
	}

	public float getPrice() {
		return price;
	}

	public Date getDateAcquired() {
		return dateAcquired;
	}

	public String getInventoryItemNumber() {
		return inventoryItemNumber;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public ItemStatus getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(ItemStatus itemStatus) {
		if (itemStatus == null)
			throw new NullArgumentException("itemStatus");
		this.itemStatus = itemStatus;
	}

	public ItemCondition getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(ItemCondition itemCondition) {
		if (itemCondition == null)
			throw new NullArgumentException("category");
		this.itemCondition = itemCondition;
	}

	public ItemCategory getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategory itemCategory) {
		if (itemCategory == null)
			throw new NullArgumentException("category");
		this.itemCategory = itemCategory;
	}

	public void setUnit(Unit unit) {
		if (unit == null)
			throw new NullArgumentException("unit");
		this.unit = unit;
	}

	public void setDescription(String description) {
		if (description == null)
			throw new NullArgumentException("description");
		this.description = description;
	}

	public void setStockNumber(String stockNumber) {
		this.stockNumber = stockNumber;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setDateAcquired(Date dateAcquired) {
		this.dateAcquired = dateAcquired;
	}

	public void setInventoryItemNumber(String inventoryItemNumber) {
		this.inventoryItemNumber = inventoryItemNumber;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int itemID) {
		this.id = itemID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Item other = (Item) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public void setDateAcquired(String string) {
		dateAcquired = java.sql.Date.valueOf(string);
	}

	public void setDateAcquired(String year, String month, String day) {
		setDateAcquired(String.format("%s-%s-%s", year, month, day));
	}

	public static boolean isDateValid(String year, String month, String day) {
		try {
			java.sql.Date.valueOf(String.format("%s-%s-%s", year, month, day));
			return true;
		} catch (IllegalArgumentException e) {
			return false;
		}
	}

	public void setPrice(String string) {
		try {
			price = Float.parseFloat(string);
		} catch (NumberFormatException e) {
		}
	}
}
