package com.iappsam.entities;

import java.sql.Date;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class BasicItemEntities {

	public ItemManager im;
	public Item item = new Item(); //"Item", "", "Description", 0.0f, new Date(0), "", "");
	public ItemCondition condition = new ItemCondition("");
	public ItemStatus status = new ItemStatus("");
	public Unit unit = new Unit("");

	public BasicItemEntities(ItemManager im) {
		super();
		this.im = im;
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
			im.removeItem(item);

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

	public void close() {
		im.close();
	}

}
