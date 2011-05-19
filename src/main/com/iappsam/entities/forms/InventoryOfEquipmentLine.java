package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IE_Line")
public class InventoryOfEquipmentLine implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3724182303894246727L;

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Employee_ID")
	private int employeeID;

	@Column(name = "How_Acquired")
	private String howAcquired;

	@Column(name = "Remarks")
	private String remarks;

	@Id
	@Column(name = "Inventory_Of_Equipment_ID")
	private int ieID;

	public InventoryOfEquipmentLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryOfEquipmentLine(String itemDescription, int quantity, int employeeID, String howAcquired, String remarks, int ieID) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.employeeID = employeeID;
		this.howAcquired = howAcquired;
		this.remarks = remarks;
		this.ieID = ieID;
	}

	public InventoryOfEquipmentLine(String itemDescription, int quantity, int employeeID, String howAcquired, int ieID) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.employeeID = employeeID;
		this.howAcquired = howAcquired;
		this.ieID = ieID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getHowAcquired() {
		return howAcquired;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getIeID() {
		return ieID;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public void setHowAcquired(String howAcquired) {
		this.howAcquired = howAcquired;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}
}
