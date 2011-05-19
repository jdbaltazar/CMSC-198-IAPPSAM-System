package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PAR_Line")
public class PropertyAcknowledgementRecieptLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 857324034318525053L;

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Property_Number")
	private String propertyNumber;

	@Column(name = "PAR_ID")
	private int parID;

	public PropertyAcknowledgementRecieptLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PropertyAcknowledgementRecieptLine(String itemDescription, String propertyNumber, int parID) {
		super();
		this.itemDescription = itemDescription;
		this.propertyNumber = propertyNumber;
		this.parID = parID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getPropertyNumber() {
		return propertyNumber;
	}

	public int getParID() {
		return parID;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setPropertyNumber(String propertyNumber) {
		this.propertyNumber = propertyNumber;
	}

	public void setParID(int parID) {
		this.parID = parID;
	}

}
