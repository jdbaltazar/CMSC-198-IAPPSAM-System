package com.iappsam.search;

import com.iappsam.entities.ItemCondition;

public class ItemConditionSearcher extends AbstractSearcher {

	public ItemConditionSearcher() {
		super(ItemCondition.class, "name");
	}
}
