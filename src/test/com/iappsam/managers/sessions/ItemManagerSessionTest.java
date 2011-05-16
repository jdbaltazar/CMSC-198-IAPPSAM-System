package com.iappsam.managers.sessions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemFactory;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	ItemManager im = new ItemManagerSession();

	@Test
	public void addItem() throws TransactionException {

		Item item = ItemFactory.createItemByName("Item");
		im.addItem(item);

	}

	@Test
	public void addItemCondition() {
		ItemCondition condition = new ItemCondition("");
	}

	@After
	public void close() {
		im.close();
	}
}
