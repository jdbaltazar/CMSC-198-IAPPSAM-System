package com.iappsam.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;

public class BasicItemEntities {

	private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	{
		calendar.clear();
		calendar.set(2010, 00, 01);
	}
	public final ItemManager im;
	public final Item item = new Item("Item", "", "Description", 0.0f, new Date(0), "", "");
	public final Item item2 = new Item("Item Again", "", "Description2", 0.0f, new Date(0), "", "");
	public final Item itemQuickBrownFox = new Item("Quick Brown Fox", "", "", 0.0f, new Date(0), "", "");
	public final Item itemDate = new Item("", "", "", 0.0f, calendar.getTime(), "", "");

	{
		calendar.clear();
		calendar.set(2010, 00, 02);
	}
	public final Item itemDate2 = new Item("", "", "", 0.0f, calendar.getTime(), "", "");

	public final Item itemTermName = new Item("Second Test", "", "Description2 Test", 0.0f, new Date(0), "", "");
	public final ItemCondition condition = new ItemCondition("");
	public final ItemStatus status = new ItemStatus("");
	public final Unit unit = new Unit("");

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
		im.addItem(item2);
		im.addItem(itemDate);
		im.addItem(itemDate2);
		im.addItem(itemTermName);
		im.addItem(itemQuickBrownFox);
	}

	public void removeAllExisting() throws TransactionException {

		if (im.containsItem(item))
			im.removeItem(item);

		if (im.containsItem(item2))
			im.removeItem(item2);

		if (im.containsItem(itemDate))
			im.removeItem(itemDate);

		if (im.containsItem(itemDate2))
			im.removeItem(itemDate2);

		if (im.containsItem(itemTermName))
			im.removeItem(itemTermName);
		
		if (im.containsItem(itemQuickBrownFox))
			im.removeItem(itemQuickBrownFox);

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
