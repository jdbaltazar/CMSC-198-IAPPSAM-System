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

	@Test
	public void addItemAndRemove() throws TransactionException {
		addEntities();
	}

	@Test(expected = TransactionException.class)
	public void addItemThenRemoveTwice() throws TransactionException {
		addEntities();

		im.removeItem(item);
		im.removeItem(item);
	}

	@After
	public void removeAllExisting() throws TransactionException {
		if (im.containsItem(item))
			im.removeItem(item);

		im.removeItemCategory(category);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
	}

	private void addEntities() throws TransactionException {
		im.addItemCategory(category);
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addUnit(unit);
		im.addItem(item);
	}
}
