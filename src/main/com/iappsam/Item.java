package com.iappsam;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.search.annotations.DateBridge;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.IndexedEmbedded;
import org.hibernate.search.annotations.Resolution;

@Entity
@Indexed
public class Item implements Serializable, Validatable {

	private static final long serialVersionUID = 4853030420797406210L;

	public static Item create(String description, String category, String unit, String status, String condition) {
		return new Item(description, new ItemCategory(category), new Unit(unit), new ItemStatus(status), new ItemCondition(condition));
	}

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
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Unit_ID")
	private Unit unit;

	@IndexedEmbedded
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Item_Status_ID")
	private ItemStatus itemStatus;

	@IndexedEmbedded
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Item_Condition_ID")
	private ItemCondition itemCondition;

	@IndexedEmbedded
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	@JoinColumn(name = "Item_Category_ID")
	private ItemCategory itemCategory;

	public Item() {
		super();
	}

	public Item(String description, String stockNumber, ItemCategory itemCategory, Unit unit, float price, Date dateAcquired,
			String inventoryItemNumber, String propertyNumber, ItemStatus itemStatus, ItemCondition itemCondition) {
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

	public ItemStatus getStatus() {
		return itemStatus;
	}

	public void setStatus(ItemStatus itemStatus) {
		this.itemStatus = itemStatus;
	}

	public ItemCondition getCondition() {
		return itemCondition;
	}

	public void setCondition(ItemCondition itemCondition) {
		this.itemCondition = itemCondition;
	}

	public ItemCategory getCategory() {
		return itemCategory;
	}

	public void setCategory(ItemCategory itemCategory) {
		this.itemCategory = itemCategory;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	public void setDescription(String description) {
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
		result = prime * result + ((dateAcquired == null) ? 0 : dateAcquired.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((inventoryItemNumber == null) ? 0 : inventoryItemNumber.hashCode());
		result = prime * result + ((itemCategory == null) ? 0 : itemCategory.hashCode());
		result = prime * result + ((itemCondition == null) ? 0 : itemCondition.hashCode());
		result = prime * result + ((itemStatus == null) ? 0 : itemStatus.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result + ((propertyNumber == null) ? 0 : propertyNumber.hashCode());
		result = prime * result + ((stockNumber == null) ? 0 : stockNumber.hashCode());
		result = prime * result + ((unit == null) ? 0 : unit.hashCode());
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
		if (dateAcquired == null) {
			if (other.dateAcquired != null)
				return false;
		} else if (!dateAcquired.equals(other.dateAcquired))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (inventoryItemNumber == null) {
			if (other.inventoryItemNumber != null)
				return false;
		} else if (!inventoryItemNumber.equals(other.inventoryItemNumber))
			return false;
		if (itemCategory == null) {
			if (other.itemCategory != null)
				return false;
		} else if (!itemCategory.equals(other.itemCategory))
			return false;
		if (itemCondition == null) {
			if (other.itemCondition != null)
				return false;
		} else if (!itemCondition.equals(other.itemCondition))
			return false;
		if (itemStatus == null) {
			if (other.itemStatus != null)
				return false;
		} else if (!itemStatus.equals(other.itemStatus))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (propertyNumber == null) {
			if (other.propertyNumber != null)
				return false;
		} else if (!propertyNumber.equals(other.propertyNumber))
			return false;
		if (stockNumber == null) {
			if (other.stockNumber != null)
				return false;
		} else if (!stockNumber.equals(other.stockNumber))
			return false;
		if (unit == null) {
			if (other.unit != null)
				return false;
		} else if (!unit.equals(other.unit))
			return false;
		return true;
	}

	public void setDateAcquired(String string) {
		try {
			dateAcquired = java.sql.Date.valueOf(string);
		} catch (Exception e) {
		}
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
		} catch (Exception e) {
		}
	}

	@Override
	public boolean validate() {
		boolean validDescription = description != null && !description.equals("");
		boolean validCategory = itemCategory != null && itemCategory.validate();
		boolean validUnit = unit != null && unit.validate();
		boolean validStatus = itemStatus != null && itemStatus.validate();
		boolean validCondition = itemCondition != null && itemCondition.validate();
		return validDescription && validCategory && validUnit && validStatus && validCondition;
	}
}
