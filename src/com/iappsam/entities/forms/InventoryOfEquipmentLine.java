package com.iappsam.entities.forms;

class InventoryOfEquipmentLine {
	private int ieID;
	private int quantity;
	private int yearAcquired;
	private int employeeID;
	private String howAcquired;
	private String remarks;
	private int ieLineID;

	private void init(int ieID, int quantity, int yearAcquired, int employeeID,
			String howAcquired, String remarks, int ieLineID) {
		this.ieID = ieID;
		this.ieLineID = ieLineID;
		this.quantity = quantity;
		this.yearAcquired = yearAcquired;
		this.employeeID = employeeID;
		this.howAcquired = howAcquired;
		this.remarks = remarks;
	}

	public InventoryOfEquipmentLine(int ieID, int employeeID,
			String howAcquired, int ieLineID) {
		init(ieID, ieID, 0, employeeID, howAcquired, "", ieLineID);
	}

	public InventoryOfEquipmentLine(int ieID, int yearAcquired, int employeeID,
			String howAcquired, String remarks, int ieLineID) {
		init(ieID, ieID, yearAcquired, employeeID, howAcquired, remarks,
				ieLineID);
	}

	public int getIeID() {
		return ieID;
	}

	
	public int getQuantity() {
		return quantity;
	}


	public int getYearAcquired() {
		return yearAcquired;
	}

	public void setYearAcquired(int yearAcquired) {
		this.yearAcquired = yearAcquired;
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

	public int getIeLineID() {
		return ieLineID;
	}

	public void setIeLineID(int ieLineID) {
		this.ieLineID = ieLineID;
	}
}
