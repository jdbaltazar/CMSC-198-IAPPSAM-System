package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item_Status")
public class ItemStatus {
	
	@Id
	@Column(name = "Item_Status")
	private String itemStatus;

	public ItemStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemStatus(String itemStatus) {
		super();
		this.itemStatus = itemStatus;
	}

	public String getItemStatus() {
		return itemStatus;
	}

	public void setItemStatus(String itemStatus) {
		this.itemStatus = itemStatus;
	}

}
