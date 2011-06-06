package com.iappsam.entities;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class ItemBuilder {

	private ItemCategory category;
	private Unit unit;
	private ItemStatus status;
	private ItemCondition condition;
	private Item item;
	private ItemManager im = new ItemManagerSession();;

	public ItemBuilder addCategory(String name) {
		category = new ItemCategory(name);
		return this;
	}

	public ItemBuilder addUnit(String name) {
		unit = new Unit(name);
		return this;
	}

	public ItemBuilder addStatus(String name) {
		status = new ItemStatus(name);
		return this;
	}

	public ItemBuilder addCondition(String name) {
		condition = new ItemCondition(name);
		return this;
	}

	public ItemBuilder addItem(String description) throws TransactionException {

		if (!isDependenciesAdded())
			throw new IllegalStateException();

		item = new Item(description, category, unit, status, condition);
		return this;
	}

	private boolean isDependenciesAdded() {
		return category != null && unit != null && status != null && condition != null;
	}

	public void addToDatabase() throws TransactionException, DuplicateEntryException {

		if (item == null || !isDependenciesAdded())
			throw new IllegalStateException();
		
		im.addUnit(unit);
		im.addItemCategory(category);
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addItem(item);
	}

	public void removeFromDatabase() throws TransactionException {
		im.removeItem(item);
		im.removeItemStatus(status);
		im.removeItemCondition(condition);
		im.removeItemCategory(category);
		im.removeUnit(unit);
	}

	public ItemCategory getCategory() {
		return category;
	}

	public Unit getUnit() {
		return unit;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public ItemCondition getCondition() {
		return condition;
	}

	public Item getItem() {
		return item;
	}
}
