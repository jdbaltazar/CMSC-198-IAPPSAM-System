package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Recapitulation_Line")
public class RecapitulationLine {
	@Id
	@Column(name = "Item_ID")
	private int itemID;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Account_Code")
	private String accountCode;
	@Column(name = "RSMI_ID")
	private int rsmiID;

	public RecapitulationLine(int itemID, int quantity, String accountCode, int rsmiID) {

		this.itemID = itemID;
		this.quantity = quantity;
		this.accountCode = accountCode;
		this.rsmiID = rsmiID;
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
}
