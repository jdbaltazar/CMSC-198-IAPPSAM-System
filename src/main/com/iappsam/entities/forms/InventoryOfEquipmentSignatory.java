package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class InventoryOfEquipmentSignatory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7753040466710185770L;

	@Id
	@Column(name = "Inventory_Of_Equipment_ID")
	private int ieId;
	
	@Id
	@Column(name = "Signatory_ID")
	private int signatoryId;

	public InventoryOfEquipmentSignatory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InventoryOfEquipmentSignatory(int ieId, int signatoryId) {
		super();
		this.ieId = ieId;
		this.signatoryId = signatoryId;
	}

	public int getIeId() {
		return ieId;
	}

	public int getSignatoryId() {
		return signatoryId;
	}

	public void setIeId(int ieId) {
		this.ieId = ieId;
	}

	public void setSignatoryId(int signatoryId) {
		this.signatoryId = signatoryId;
	}
	
}
