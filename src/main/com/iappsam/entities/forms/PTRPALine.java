package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PTRPA_Line")
public class PTRPALine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8627208031076638913L;

	@Id
	@Column(name = "Item_Description")
	private String itemDescription;

	@Column(name = "ARE_MR_Number")
	private String areMRNumber;

	@Column(name = "Quantity")
	private int quantity;

	@Column(name = "Remarks")
	private String remarks;

	@Id
	@Column(name = "PTRPA_ID")
	private int ptrpaID;

	public PTRPALine() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PTRPALine(String itemDescription, String areMRNumber, int quantity, String remarks, int ptrpaID) {
		super();
		this.itemDescription = itemDescription;
		this.areMRNumber = areMRNumber;
		this.quantity = quantity;
		this.remarks = remarks;
		this.ptrpaID = ptrpaID;
	}

	public PTRPALine(String itemDescription, int quantity, int ptrpaID) {
		super();
		this.itemDescription = itemDescription;
		this.quantity = quantity;
		this.ptrpaID = ptrpaID;
	}

	public String getItemDescription() {
		return itemDescription;
	}

	public String getAreMRNumber() {
		return areMRNumber;
	}

	public int getQuantity() {
		return quantity;
	}

	public String getRemarks() {
		return remarks;
	}

	public int getPtrpaID() {
		return ptrpaID;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	public void setAreMRNumber(String areMRNumber) {
		this.areMRNumber = areMRNumber;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setPtrpaID(int ptrpaID) {
		this.ptrpaID = ptrpaID;
	}
	
}
