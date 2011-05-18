package com.iappsam.entities.forms;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "IE_Signatory")
public class IESignatory implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5351085913251016400L;

	@Id
	@Column(name = "Inventory_Of_Equipment_ID")
	private int ieID;

	@Id
	@Column(name = "Signatory_ID")
	private int signatoyrID;

	public IESignatory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public IESignatory(int ieID, int signatoyrID) {
		super();
		this.ieID = ieID;
		this.signatoyrID = signatoyrID;
	}

	public int getIeID() {
		return ieID;
	}

	public int getSignatoyrID() {
		return signatoyrID;
	}

	public void setIeID(int ieID) {
		this.ieID = ieID;
	}

	public void setSignatoyrID(int signatoyrID) {
		this.signatoyrID = signatoyrID;
	}

}
