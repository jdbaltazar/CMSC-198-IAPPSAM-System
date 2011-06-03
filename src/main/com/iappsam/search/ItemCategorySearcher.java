package com.iappsam.search;

import com.iappsam.entities.ItemCategory;

public class ItemCategorySearcher extends AbstractSearcher {

	public ItemCategorySearcher() {
		super(ItemCategory.class, "name");
	}
}
