package com.iappsam.forms;

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
	@Column(name = "RIS_Number")
	private int risNumber;

	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Responsibility_Center")
	private String responsibilityCenter;

	@Id
	@Column(name = "RSMI_ID")
	private int rsmiID;

	public RSMILine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RSMILine(int risNumber, int itemID, String responsibilityCenter, int rsmiID) {
		super();
		this.risNumber = risNumber;
		this.itemID = itemID;
		this.responsibilityCenter = responsibilityCenter;
		this.rsmiID = rsmiID;
	}

	public RSMILine(int risNumber, int itemID, int rsmiID) {
		super();
		this.risNumber = risNumber;
		this.itemID = itemID;
		this.rsmiID = rsmiID;
	}

	public int getRisNumber() {
		return risNumber;
	}

	public int getItemID() {
		return itemID;
	}

	public String getResponsibilityCenter() {
		return responsibilityCenter;
	}

	public int getRsmiID() {
		return rsmiID;
	}

	public void setRisNumber(int risNumber) {
		this.risNumber = risNumber;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setResponsibilityCenter(String responsibilityCenter) {
		this.responsibilityCenter = responsibilityCenter;
	}

	public void setRsmiID(int rsmiID) {
		this.rsmiID = rsmiID;
	}

}
