package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ModeOfProcurement {
	
	@Id
	@Column(name = "Mode_Of_Procurement")
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

}
