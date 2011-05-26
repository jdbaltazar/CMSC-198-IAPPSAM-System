package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Id;

public class ModeOfProcurement {
	
	@Id
	@Column(name = "Mode_Of_Procurement")
	private String modeOfProcurement;

	public ModeOfProcurement() {
		super();
		// TODO Auto-generated constructor stub
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
