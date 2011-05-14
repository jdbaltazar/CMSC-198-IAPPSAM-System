package com.iappsam.entities.forms;

public class PurchaseOrderLine {
	private int poLineID;
	private int poID;
	private int itemID;

	public PurchaseOrderLine(int poLineID, int poID, int itemID) {
		this.poLineID = poLineID;
		this.poID = poID;
		this.itemID = itemID;
	}

	public int getPoLineID() {
		return poLineID;
	}

	public int getPoID() {
		return poID;
	}

	public int getItemID() {
		return itemID;
	}

}
