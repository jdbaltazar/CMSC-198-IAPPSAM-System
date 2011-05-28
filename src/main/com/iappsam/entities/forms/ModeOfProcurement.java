package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Mode_Of_Procurement")
public class ModeOfProcurement {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Mode_Of_Procurement_ID")
	private int id;

	@Column(name = "Name")
	private String modeOfProcurement;

	public ModeOfProcurement() {
		super();
	}

	public ModeOfProcurement(String modeOfProcurement) {
		super();
		this.modeOfProcurement = modeOfProcurement;
	}

	public String getModeOfProcurement() {
		return modeOfProcurement;
	}

	public void setModeOfProcurement(String modeOfProcurement) {
		this.modeOfProcurement = modeOfProcurement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
