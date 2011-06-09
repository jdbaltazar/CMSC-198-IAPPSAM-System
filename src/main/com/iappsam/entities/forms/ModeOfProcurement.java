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
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "Mode_Of_Procurement_ID")
	private int id;

	@Column(name = "Name")
	private String name;

	public ModeOfProcurement() {
		super();
	}

	public ModeOfProcurement(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
