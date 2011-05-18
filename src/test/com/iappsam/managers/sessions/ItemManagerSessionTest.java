package com.iappsam.managers.sessions;


import org.junit.After;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemManagerFactory;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	ItemManager im = new ItemManagerSession();

	@Test
	public void addItemAndRemove() throws TransactionException {

		ItemCondition condition = new ItemCondition("");
		im.addItemCondition(condition);

		ItemStatus status = new ItemStatus("");
		im.addItemStatus(status);

		Unit unit = new Unit("");
		im.addUnit(unit);

		Item item = ItemManagerFactory.createItemByName("Item");
		im.addItem(item);
		im.removeItem(item);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
	}

	@After
	public void removeAllAndClose() throws TransactionException {

		im.close();
	}
}
