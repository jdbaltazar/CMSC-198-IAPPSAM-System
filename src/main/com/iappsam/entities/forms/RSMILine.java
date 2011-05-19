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
	@Column(name = "RIS_Number")
	private int risNumber;

	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "Responsibility_Center")
	private String responsibilityCenter;

	@Id
	@Column(name = "RSMI_ID")
	private int rsmiID;

	public RSMILine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RSMILine(int risNumber, String itemDescription, String responsibilityCenter, int rsmiID) {
		super();
		this.risNumber = risNumber;
		this.itemDescription = itemDescription;
		this.responsibilityCenter = responsibilityCenter;
		this.rsmiID = rsmiID;
	}

	public RSMILine(int risNumber, String itemDescription, int rsmiID) {
		super();
		this.risNumber = risNumber;
		this.itemDescription = itemDescription;
		this.rsmiID = rsmiID;
	}

	public int getRisNumber() {
		return risNumber;
	}

	public String getItemDescription() {
		return itemDescription;
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

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setResponsibilityCenter(String responsibilityCenter) {
		this.responsibilityCenter = responsibilityCenter;
	}

	public void setRsmiID(int rsmiID) {
		this.rsmiID = rsmiID;
	}
	
}
