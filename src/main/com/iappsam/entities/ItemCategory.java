package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemCategory {

	@Id
	@Column(name = "Item_Category")
	private String itemCategory;

	public ItemCategory() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemCategory(String itemCategory) {
		super();
		this.itemCategory = itemCategory;
	}

	public String getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(String itemCategory) {
		this.itemCategory = itemCategory;
	}
}
