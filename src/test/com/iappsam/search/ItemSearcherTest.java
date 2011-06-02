package com.iappsam.search;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class ItemSearcherTest {

	private static ItemManager im;
	private static AbstractSearcher s;

	private final ItemCategory category = new ItemCategory("Category");
	private final Unit unit = new Unit("Unit");
	private final ItemStatus status = new ItemStatus("Status");
	private final ItemCondition condition = new ItemCondition("Condition");

	private final Item item = new Item("item", category, unit, status, condition);
	private final Item item2 = new Item("Description item", category, unit, status, condition);
	private final Item itemQuickBrownFox = new Item("Quick Brown Fox", category, unit, status, condition);
	private final Item itemTermName = new Item("Descriptions second", category, unit, status, condition);
	private final Item itemDate = new Item("Date1", category, unit, status, condition);
	private final Item itemDate2 = new Item("Date2", category, unit, status, condition);

	@BeforeClass
	public static void initManagers() {
		im = new ItemManagerSession();
		s = new ItemSearcher();
	}

	@Before
	public void init() throws TransactionException {
		EntityRemover.removeAll();

		itemDate.setDateAcquired(Date.valueOf("2010-01-01"));
		itemDate2.setDateAcquired(Date.valueOf("2010-01-02"));
		addAll();
	}

	@Test
	public void searchItemName() throws TransactionException {
		List<Item> result = s.search("Item");

		assertEquals(2, result.size());
		assertTrue(result.contains(item));
		assertTrue(result.contains(item2));
	}

	@Test
	public void searchItemNameWildcard() throws TransactionException {
		List<Item> result = s.search("Ite");

		assertEquals(2, result.size());
		assertTrue(result.contains(item));
		assertTrue(result.contains(item2));
	}

	@Test
	public void searchItemNameLeadingWildcard() throws TransactionException {
		List<Item> result = s.search("tem");

		assertEquals(2, result.size());
		assertTrue(result.contains(item));
		assertTrue(result.contains(item2));
	}

	@Test
	public void searchNonConsecutiveTerm() {
		List<Item> result = s.search("Quick Fox");

		assertEquals(1, result.size());
		assertTrue(result.contains(itemQuickBrownFox));
	}

	@Ignore
	@Test
	public void searchByDate() {

		List<Item> result = s.search("20100101"); // January 1, 2010

		assertEquals(1, result.size());
		assertTrue(result.contains(itemDate));
	}

	@Ignore
	@Test
	public void searchByDateRange() {
		List<Item> result = s.search("[20100101 TO 20100102]");

		assertEquals(2, result.size());
		assertTrue(result.contains(itemDate));
		assertTrue(result.contains(itemDate2));
	}

	@Test
	public void searchCaseInsensitive() {
		List<Item> result = s.search("SECOND");

		assertEquals(1, result.size());
		assertTrue(result.contains(itemTermName));
	}

	@Test
	public void searchItemDescription() throws TransactionException {
		List<Item> result = s.search("Descriptions");

		assertEquals(1, result.size());
		assertTrue(result.contains(itemTermName));
	}

	private void addAll() throws TransactionException {
		im.addItemCategory(category);
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
}
