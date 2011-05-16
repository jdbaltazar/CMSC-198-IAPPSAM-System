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

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ICS_Line_ID", nullable = false)
	private int icsLineID;
	
	@Column(name = "Quantity", nullable = false)
	private int quantity;
	
	@Column(name = "Item_ID", nullable = false)
	private int itemID;
	
	@Column(name = "Estimated_Useful_Life", nullable = false)
	private int estimatedusefulLife;
	
	@Id
	@Column(name = "ICS_ID", nullable = false)
	private int icsID;

	public InventoryCustodianSlipLine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryCustodianSlipLine(int icsLineID, int quantity, int itemID, int estimatedusefulLife, int icsID) {
		super();
		setIcsLineID(icsLineID);
		setQuantity(quantity);
		setItemID(itemID);
		setEstimatedusefulLife(estimatedusefulLife);
		setIcsID(icsID);
	}

	public int getIcsLineID() {
		return icsLineID;
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

	public void setIcsLineID(int icsLineID) {
		this.icsLineID = icsLineID;
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
