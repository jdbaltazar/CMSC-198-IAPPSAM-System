package com.iappsam.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ItemCategory {

	public static final String COMMON_OFFICE_SUPPLIES = "Common Office Supplies";
	public static final String OTHER_OFFICE_SUPPLIES = "Other Office Supplies";
	public static final String OTHER_OFFICE_DEVICES = "Other Office Devices";
	public static final String COMMON_OFFICE_SUPPLIES_ED = "Common Office Supplies (Exclusive Distributorship";
	public static final String COMMON_COMPUTER_SUPPLIES = "Common Computer Supplies";
	public static final String COMMON_ELECTRICAL_PLANNING_SUPPLIES = "Common Electrical/Planing Supplies";
	public static final String COMMON_OFFICE_FORMS = "Office Forms (for Purchasing)";
	public static final String OTHERS = "Others";

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
