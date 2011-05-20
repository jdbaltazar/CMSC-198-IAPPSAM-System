package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recapitulation_Line")
public class RecapitulationLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6962275925598771723L;

	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Account_Code")
	private String accountCode;
	
	@Id
	@Column(name = "RSMI_ID")
	private int rsmiID;

	public RecapitulationLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RecapitulationLine(int itemID, int quantity, String accountCode, int rsmiID) {
		super();
		this.itemID = itemID;
		this.quantity = quantity;
		this.accountCode = accountCode;
		this.rsmiID = rsmiID;
	}

	public int getItemID() {
		return itemID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getAccountCode() {
		return accountCode;
	}

	public int getRsmiID() {
		return rsmiID;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setAccountCode(String accountCode) {
		this.accountCode = accountCode;
	}

	public void setRsmiID(int rsmiID) {
		this.rsmiID = rsmiID;
	}
	
}
