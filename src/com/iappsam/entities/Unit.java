package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Unit {

	@Id
	@Column(name = "Unit")
	private String unit;

	public Unit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Unit(String unit) {
		super();
		this.unit = unit;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
}
