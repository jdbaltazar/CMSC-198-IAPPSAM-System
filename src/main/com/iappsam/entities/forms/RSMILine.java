package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RSMI_Line")
public class RSMILine implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6680944389292444506L;
	@Id
	@Column(name = "RSMI_ID")
	private int rsmiID;
	@Id
	@Column(name = "RSMI_Number")
	private String rsmiNumber;
	@Column(name = "Item_ID")
	private int itemID;
	@Column(name = "Responsibility_Center")
	private String responsibilityCenter;

	private void init(int itemID, int rsmiID, String rsmiNumber, String responsibilityCenter) {
		this.itemID = itemID;
		this.rsmiID = rsmiID;
		this.rsmiNumber = rsmiNumber;
		this.responsibilityCenter = responsibilityCenter;
	}

	public RSMILine(int itemID, int rsmiID, String rsmiNumber) {
		init(itemID, rsmiID, rsmiNumber, "");
	}

	public RSMILine(int itemID, int rsmiID, String rsmiNumber, String responsibilityCenter) {
		init(itemID, rsmiID, rsmiNumber, responsibilityCenter);
	}

	public RSMILine() {
	};

	public int getItemID() {
		return itemID;
	}

	public String getRsmiNumber() {
		return rsmiNumber;
	}

	public void setRsmiNumber(String rsmiNumber) {
		this.rsmiNumber = rsmiNumber;
	}

	public void setRsmiID(int rsmiID) {
		this.rsmiID = rsmiID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public String getResponsibilityCenter() {
		return responsibilityCenter;
	}

	public void setResponsibilityCenter(String responsibilityCenter) {
		this.responsibilityCenter = responsibilityCenter;
	}

	public int getRsmiID() {
		return rsmiID;
	}

}
