package com.iappsam.managers.sessions;

import java.util.Date;

import org.junit.After;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private ItemManagerSession im = new ItemManagerSession();

	public final ItemCondition condition = new ItemCondition("");
	public final ItemStatus status = new ItemStatus("");
	public final Unit unit = new Unit("");
	public final Item item = new Item("Item", "", "Description", 0.0f, new Date(0), "", "");

	private void removeAllExisting() throws TransactionException {
		if (im.containsItem(item))
			im.removeItem(item);

		if (im.containsUnit(unit))
			im.removeUnit(unit);

		if (im.containsItemCondition(condition))
			im.removeItemCondition(condition);

		if (im.containsItemStatus(status))
			im.removeItemStatus(status);
	}

	@Test
	public void addItemAndRemove() throws TransactionException {
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addUnit(unit);
		im.addItem(item);
		im.removeItem(item);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
	}

	@Test(expected = TransactionException.class)
	public void addItemThenRemoveTwice() throws TransactionException {
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addUnit(unit);
		im.addItem(item);
		im.removeItem(item);
		im.removeItem(item);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
	}

	@After
	public void removeAllAndClose() throws TransactionException {
		removeAllExisting();
		im.close();
	}
}
