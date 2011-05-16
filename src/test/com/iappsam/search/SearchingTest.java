package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemManagerFactory;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class SearchingTest {

	@Test
	public void searchItemName() throws TransactionException {

		ItemManager im = new ItemManagerSession();

		ItemCondition condition = new ItemCondition("");
		im.addItemCondition(condition);

		ItemStatus status = new ItemStatus("");
		im.addItemStatus(status);

		Unit unit = new Unit("");
		im.addUnit(unit);

		Item item = ItemManagerFactory.createItemByName("Item");

		Searcher s = new ItemSearcher();
		List<Item> result = s.search("Item");

		assertTrue(result.contains(item));

		im.removeItem(item);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
	}
}
