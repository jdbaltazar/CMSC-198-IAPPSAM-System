package com.iappsam.entities;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class ItemFactory {

	private static ItemCategory category;
	private static Unit unit;
	private static ItemStatus status;
	private static ItemCondition condition;
	private static Item item;

	public static Item createPersistedItem(String description) throws TransactionException {
		ItemManager im = new ItemManagerSession();

		category = new ItemCategory("Cat");
		unit = new Unit("Kg");
		status = new ItemStatus("Good");
		condition = new ItemCondition("Better");
		item = new Item(description, category.getItemCategory(), unit.getUnit(), status.getItemStatus(), condition.getItemCondition());

		if (!im.containsItemCategory(category))
			im.addItemCategory(category);

		if (!im.containsUnit(unit))
			im.addUnit(unit);

		if (!im.containsItemStatus(status))
			im.addItemStatus(status);

		if (!im.containsItemCondition(condition))
			im.addItemCondition(condition);

		if (!im.containsItem(item))
			im.addItem(item);

		return item;
	}

	public static void removeItemDependencies() throws TransactionException {
		ItemManager im = new ItemManagerSession();

		if (im.containsItemCategory(category))
			im.removeItemCategory(category);

		if (im.containsItemCondition(condition))
			im.removeItemCondition(condition);

		if (im.containsItemStatus(status))
			im.removeItemStatus(status);

		if (im.containsUnit(unit))
			im.removeUnit(unit);
	}
}
