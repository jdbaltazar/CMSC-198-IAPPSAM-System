package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Item_Condition")
public class ItemCondition {
	
	@Id
	@Column(name = "Item_Condition")
	private String itemCondition;

	public ItemCondition() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCondition(String itemCondition) {
		super();
		this.itemCondition = itemCondition;
	}

	public String getItemCondition() {
		return itemCondition;
	}

	public void setItemCondition(String itemCondition) {
		this.itemCondition = itemCondition;
	}
	
}
