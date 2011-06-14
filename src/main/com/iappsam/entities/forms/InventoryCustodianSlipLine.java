package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ICS_Line")
public class InventoryCustodianSlipLine implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1882633688697555808L;
	
	@Column(name = "Quantity")
	private int quantity;
	
	@Id
	@Column(name = "Item_ID")
	private int itemID;
	
	@Column(name = "Estimated_Useful_Life")
	private int estimatedusefulLife;
	
	@Id
	@Column(name = "ICS_ID")
	private int icsID;

	public InventoryCustodianSlipLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryCustodianSlipLine(int quantity, int itemID, int estimatedusefulLife, int icsID) {
		super();
		this.quantity = quantity;
		this.itemID = itemID;
		this.estimatedusefulLife = estimatedusefulLife;
		this.icsID = icsID;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItemID() {
		return itemID;
	}

	public int getEstimatedusefulLife() {
		return estimatedusefulLife;
	}

	public int getIcsID() {
		return icsID;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setItemID(int itemID) {
		this.itemID = itemID;
	}

	public void setEstimatedusefulLife(int estimatedusefulLife) {
		this.estimatedusefulLife = estimatedusefulLife;
	}

	public void setIcsID(int icsID) {
		this.icsID = icsID;
	}
	
}
