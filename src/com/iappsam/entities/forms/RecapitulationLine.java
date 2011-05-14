package com.iappsam.entities.forms;

public class RecapitulationLine {
	private int recapitulationLineID;
	private int itemID;
	private int quantity;
	private String accountCode;
	private int rsmiID;

	public RecapitulationLine(int recapitulationLineID, int itemID,
			int quantity, String accountCode, int rsmiID) {
		this.recapitulationLineID = recapitulationLineID;
		this.itemID = itemID;
		this.quantity = quantity;
		this.accountCode = accountCode;
		this.rsmiID = rsmiID;
	}

	public int getRecapitulationLineID() {
		return recapitulationLineID;
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
