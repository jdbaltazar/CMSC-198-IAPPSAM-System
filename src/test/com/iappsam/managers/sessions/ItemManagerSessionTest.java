package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.Item;
import com.iappsam.ItemCategory;
import com.iappsam.ItemStatus;
import com.iappsam.Unit;
import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemManagerSessionTest {

	private static ItemManagerSession im;
	public final Item item = Item.create("Description", "Category", "Unit", "Status", "Condition");

	@BeforeClass
	public static void initItemManager() {
		im = new ItemManagerSession();
	}

	@Before
	public void cleanupDatabase() throws TransactionException {
		EntityRemover.removeItems();
		EntityRemover.removeItemProperties();
	}

	@Test
	public void addItemAndRemove() throws TransactionException, DuplicateEntryException {
		im.addItem(item);
	}

	@Test(expected = TransactionException.class)
	public void addItemThenRemoveTwice() throws TransactionException, DuplicateEntryException {
		im.addItem(item);

		im.removeItem(item);
		im.removeItem(item);
	}

	@Test
	public void getItemCategoryByName() throws TransactionException, DuplicateEntryException {
		ItemCategory category = new ItemCategory("category name");
		im.addItemCategory(category);
		assertEquals(category, im.getItemCategoryByName(category.getName()));
	}

	@Test
	public void getUnitByName() throws TransactionException, DuplicateEntryException {
		Unit unit = new Unit("unit name");
		im.addUnit(unit);
		assertEquals(unit, im.getUnitByName(unit.getName()));
	}

	@Test
	public void getItemStatusByName() throws TransactionException, DuplicateEntryException {
		ItemStatus status = new ItemStatus("Status Name");
		im.addItemStatus(status);
		assertEquals(status, im.getItemStatusByName(status.getName()));
	}

	@Test
	public void getItemByDescription() throws TransactionException, DuplicateEntryException {
		Item it = Item.create("Item Description", "c", "u", "s", "c");
		im.addItem(it);
		assertEquals(it, im.getItemByDescription(it.getDescription()));
	}

	@Test
	public void cascadedItemProperties() throws TransactionException {
		Item item = Item.create("cas", "cat1", "unit1", "stat1", "con1");
		im.addItem(item);
		assertEquals(item, im.getItem(item));
	}
}
