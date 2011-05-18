package com.iappsam.entities;

import java.sql.Date;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class BasicItemEntities {

	private ItemManager im;
	private Item item = new Item("Item", "", "Description", 0.0f, new Date(0), "", "");
	private ItemCondition condition = new ItemCondition("");
	private ItemStatus status = new ItemStatus("");
	private Unit unit = new Unit("");

	public BasicItemEntities(ItemManager im) {
		super();
		this.im = im;
	}

	public Item getItem() {
		return item;
	}

	public ItemCondition getCondition() {
		return condition;
	}

	public ItemStatus getStatus() {
		return status;
	}

	public Unit getUnit() {
		return unit;
	}

	public void addAll() throws TransactionException {
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addUnit(unit);
		im.addItem(item);
	}

	public void removeAllIfExist() throws TransactionException {

		if (im.containsItem(item))
			removeItem();

		if (im.containsUnit(unit))
			removeUnit();

		if (im.containsItemCondition(condition))
			removeItemCondition();

		if (im.containsItemStatus(status))
			removeItemStatus();
	}

	public void removeItemStatus() throws TransactionException {
		im.removeItemStatus(status);
	}

	public void removeItemCondition() throws TransactionException {
		im.removeItemCondition(condition);
	}

	public void removeUnit() throws TransactionException {
		im.removeUnit(unit);
	}

	public void removeItem() throws TransactionException {
		im.removeItem(item);
	}

	public void close() {
		im.close();
	}

}
