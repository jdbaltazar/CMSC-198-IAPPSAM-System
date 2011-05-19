package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@Column(name = "Item_Description")
	private String itemDescription;
	
	@Column(name = "Estimated_Useful_Life")
	private int estimatedusefulLife;
	
	@Id
	@Column(name = "ICS_ID")
	private int icsID;

	public InventoryCustodianSlipLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryCustodianSlipLine(int quantity, String itemDescription, int estimatedusefulLife, int icsID) {
		super();
		this.quantity = quantity;
		this.itemDescription = itemDescription;
		this.estimatedusefulLife = estimatedusefulLife;
		this.icsID = icsID;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getItemDescription() {
		return itemDescription;
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

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setEstimatedusefulLife(int estimatedusefulLife) {
		this.estimatedusefulLife = estimatedusefulLife;
	}

	public void setIcsID(int icsID) {
		this.icsID = icsID;
	}
	
}
