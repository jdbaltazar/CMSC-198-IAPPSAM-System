package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IE_Line")
public class InventoryOfEquipmentLine {

	@Id
	@GeneratedValue
	@Column(name = "Item_ID")
	private int itemID;

	@Id
	@GeneratedValue
	@Column(name = "Inventory_Of_Equipment_ID")
	private int ieID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Employee_ID")
	private int employeeID;

	@Column(name = "How_Acquired")
	private String howAcquired;

	@Column(name = "Remarks")
	private String remarks;

	private void init(int ieID, int itemID, int quantity, int employeeID, String howAcquired, String remarks) {
		this.ieID = ieID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.employeeID = employeeID;
		this.howAcquired = howAcquired;
		this.remarks = remarks;
	}

	public InventoryOfEquipmentLine(int ieID, int employeeID, String howAcquired, int ieLineID) {
		init(ieID, 0, 0, employeeID, howAcquired, "");
	}

	public InventoryOfEquipmentLine(int ieID, int itemID, int quantity, int employeeID, String howAcquired, String remarks, int ieLineID) {
		init(ieID, itemID, quantity, employeeID, howAcquired, remarks);
	}

	public int getIeID() {
		return ieID;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItemID() {
		return itemID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}

	public int getEmployeeID() {
		return employeeID;
	}

	public String getHowAcquired() {
		return howAcquired;
	}

	public void setHowAcquired(String howAcquired) {
		this.howAcquired = howAcquired;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

}
