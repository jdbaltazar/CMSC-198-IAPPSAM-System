package com.iappsam.search;

import com.iappsam.entities.Item;

public class ItemSearcher extends AbstractSearcher<Item> {

	public ItemSearcher() {
		super(Item.class, "description", "itemCondition.name", "itemCategory.name", "unit.name", "itemStatus.name");
	}
}
