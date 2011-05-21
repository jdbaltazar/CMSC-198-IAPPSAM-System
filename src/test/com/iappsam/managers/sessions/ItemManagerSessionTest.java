package com.iappsam.managers.sessions;

import org.junit.After;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private ItemManager im = new ItemManagerSession();

	public final ItemCategory category = new ItemCategory("Category");
	public final Unit unit = new Unit("Unit");
	public final ItemStatus status = new ItemStatus("Status");
	public final ItemCondition condition = new ItemCondition("Condition");
	public final Item item = new Item("Description", "Category", "Unit", "Status", "Condition");

	private void removeAllExisting() throws TransactionException {
		if (im.containsItem(item))
			im.removeItem(item);

		if (im.containsItemCategory(category))
			im.removeItemCategory(category);
		
		if (im.containsUnit(unit))
			im.removeUnit(unit);

		if (im.containsItemCondition(condition))
			im.removeItemCondition(condition);

		if (im.containsItemStatus(status))
			im.removeItemStatus(status);
	}

	@Test
	public void addItemAndRemove() throws TransactionException {
		im.addItemCategory(category);
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
		im.addItemCategory(category);
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
