package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disposal {
	
	@Id
	@Column(name = "Disposal")
	private String disposal;

	public Disposal() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Disposal(String disposal) {
		super();
		this.disposal = disposal;
	}

	public String getDisposal() {
		return disposal;
	}

	public void setDisposal(String disposal) {
		this.disposal = disposal;
	}
	
}
