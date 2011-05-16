package com.iappsam.search;

import java.sql.Date;
import java.util.List;

import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemFactory;

public class SearchAcceptance {

	// @Test
	public void searchItemName() {
		Item item = ItemFactory.createItemByName("Item");

		Searcher s = new ItemSearcher();
		List<Item> result = s.search("Item");

		result.contains(item);
	}
}
