package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private ItemManagerSession im = new ItemManagerSession();

	public final ItemCategory category = new ItemCategory("Category");
	public final Unit unit = new Unit("Unit");
	public final ItemStatus status = new ItemStatus("Status");
	public final ItemCondition condition = new ItemCondition("Condition");
	public final Item item = new Item("Description", category, unit, status, condition);

	@Before
	public void cleanUpDatabase() throws TransactionException {
		EntityRemover.removeAll();
	}

	@Test
	public void addItemAndRemove() throws TransactionException, DuplicateEntryException {
		addEntities();
	}

	@Test(expected = TransactionException.class)
	public void addItemThenRemoveTwice() throws TransactionException, DuplicateEntryException {
		addEntities();

		im.removeItem(item);
		im.removeItem(item);
	}

	@Test
	public void getItemCategoryByName() throws TransactionException, DuplicateEntryException {
		String name = "category name";
		ItemCategory category = new ItemCategory(name);
		im.addItemCategory(category);

		assertEquals(name, im.getItemCategoryByName(name).getName());

		im.removeItemCategory(category);
	}

	@Test
	public void getUnitByName() throws TransactionException, DuplicateEntryException {
		String name = "unit name";
		Unit unit = new Unit(name);

		try {
			im.addUnit(unit);
			assertEquals(name, im.getUnitByName(name).getName());
		} finally {
			im.removeUnit(unit);
		}
	}

	@Test
	public void getItemStatusByName() throws TransactionException, DuplicateEntryException {
		String name = "Status Name";
		ItemStatus status = new ItemStatus(name);

		try {
			im.addItemStatus(status);
			assertEquals(name, im.getItemStatus(name).getName());
		} finally {
			im.removeItemStatus(status);
		}
	}

	@Test
	public void getItemByDescription() throws TransactionException, DuplicateEntryException {

		String description = "Item Description";

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("c").addCondition("c").addStatus("s").addUnit("u").addItem(description);

		try {
			builder.addToDatabase();
			assertEquals(description, im.getItemByDescription(description).getDescription());
		} finally {
			builder.removeFromDatabase();
		}
	}

	private void addEntities() throws TransactionException, DuplicateEntryException {
		im.addItemCategory(category);
		im.addItemCondition(condition);
		im.addItemStatus(status);
		im.addUnit(unit);
		im.addItem(item);
	}
}
