package com.iappsam.entities;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class ItemFactory {

	public static Item createPersistedItem(String description) throws TransactionException {
		ItemManager im = new ItemManagerSession();

		ItemCategory category = new ItemCategory("Cat");
		Unit unit = new Unit("Kg");
		ItemStatus status = new ItemStatus("Good");
		ItemCondition condition = new ItemCondition("Better");
		Item item = new Item(description, category.getItemCategory(), unit.getUnit(), status.getItemStatus(), condition.getItemCondition());

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

}
