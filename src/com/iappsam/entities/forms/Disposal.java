package com.iappsam.entities.forms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Disposal {
	
	public final String DESTROYED = "DESTROYED";
	public final String SOLD_AT_PRIVATE_SALE = "SOLD_AT_PRIVATE_SALE";
	public final String SOLD_AT_PUBLIC_AUCTION = "SOLD_AT_PUBLIC_AUCTION";
	public final String TRANSFERRED_WITHOUT_COST = "TRANSFERRED_WITHOUT_COST";
	
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
