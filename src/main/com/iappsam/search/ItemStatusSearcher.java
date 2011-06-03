package com.iappsam.search;

import com.iappsam.entities.ItemStatus;

public class ItemStatusSearcher extends AbstractSearcher {

	public ItemStatusSearcher() {
		super(ItemStatus.class, "name");
	}
}
