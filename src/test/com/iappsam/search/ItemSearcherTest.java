package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemSearcherTest extends ItemManagerTestSuite {

	private static AbstractSearcher<Item> s;

	private static final ItemCategory category = new ItemCategory("Category");
	private static final Unit unit = new Unit("Unit");
	private static final ItemStatus status = new ItemStatus("Status");
	private static final ItemCondition condition = new ItemCondition("Condition");

	private static final Item item = new Item("item", category, unit, status, condition);
	private static final Item item2 = new Item("Description item", category, unit, status, condition);
	private static final Item itemQuickBrownFox = new Item("Quick Brown Fox", category, unit, status, condition);
	private static final Item itemTermName = new Item("Descriptions second", category, unit, status, condition);
	private static final Item itemDate = new Item("Date1", category, unit, status, condition);
	private static final Item itemDate2 = new Item("Date2", category, unit, status, condition);

	@BeforeClass
	public static void initSearcher() throws TransactionException {
		s = new ItemSearcher();
		EntityRemover.removeAll();
		itemDate.setDateAcquired("2010-01-01");
		itemDate2.setDateAcquired("2010-01-02");
		addAll();
	}

	@Test
	public void searchStatus() {
		List<Item> result = s.search("Status");
		assertEquals(6, result.size());
	}

	@Test
	public void searchUnit() {
		List<Item> result = s.search("Unit");
		assertEquals(6, result.size());
	}

	@Test
	public void searchCategory() {
		List<Item> result = s.search("Category");
		assertEquals(6, result.size());
	}

	@Test
	public void searchCondition() {
		List<Item> result = s.search("condition");
		assertEquals(6, result.size());
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

	private static void addAll() throws TransactionException {
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
