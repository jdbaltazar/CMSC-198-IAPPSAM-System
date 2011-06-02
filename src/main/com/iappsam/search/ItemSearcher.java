package com.iappsam.search;

import com.iappsam.entities.Item;

public class ItemSearcher extends AbstractSearcher {

	public ItemSearcher() {
		super(Item.class, "description");
	}
}
