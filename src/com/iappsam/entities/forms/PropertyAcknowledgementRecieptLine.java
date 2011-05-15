package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAR_Line")
public class PropertyAcknowledgementRecieptLine {
	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Property_Number")
	private String propertyNumber;

	@Column(name = "PAR_ID")
	private int parID;

	private void init(int parID, int itemID, String propertyNumber) {
		this.parID = parID;
		this.propertyNumber = propertyNumber;
		this.itemID = itemID;
	}

	public PropertyAcknowledgementRecieptLine(int parID, int itemID) {
		init(parID, itemID, "");
	}

	public PropertyAcknowledgementRecieptLine(int parID, int itemID, String propertyNumber) {
		init(parID, itemID, propertyNumber);
	}

	public int getParID() {
		return parID;
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
