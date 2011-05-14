package com.iappsam.entities.forms;

public class PropertyAcknowledgementRecieptLine {
	private int parID;
	private int parLineID;
	private String propertyNumber;
	private int itemID;

	private void init(int parID, int itemID, String propertyNumber,
			int parLineID) {
		this.parID = parID;
		this.parLineID = parLineID;
		this.propertyNumber = propertyNumber;
		this.itemID = itemID;
	}

	public PropertyAcknowledgementRecieptLine(int parID, int itemID,
			int parLineID) {
		init(parID, itemID, "", parLineID);
	}

	public PropertyAcknowledgementRecieptLine(int parID, int itemID,
			String propertyNumber, int parLineID) {
		init(parID, itemID, propertyNumber, parLineID);
	}

	public int getParID() {
		return parID;
	}

	public int getParLineID() {
		return parLineID;
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

}
