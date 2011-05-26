package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCategory;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class SearchingTest {

	private ItemManager im = new ItemManagerSession();
	private Searcher s;

	private final ItemCategory category = new ItemCategory("Category");
	private final Unit unit = new Unit("Unit");
	private final ItemStatus status = new ItemStatus("Status");
	private final ItemCondition condition = new ItemCondition("Condition");

	private final Item item = new Item("item Description", "Category", "Unit", "Status", "Condition");
	private final Item item2 = new Item("Descriptions item", "Category", "Unit", "Status", "Condition");
	private final Item itemQuickBrownFox = new Item("Quick Brown Fox", "Category", "Unit", "Status", "Condition");
	private final Item itemTermName = new Item("Descriptions second", "Category", "Unit", "Status", "Condition");

	private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	{
		calendar.clear();
		calendar.set(2010, 00, 01);
	}

	public final Item itemDate = new Item("Date1", "Category", "Unit", "Status", "Condition");
	{
//		itemDate.setDateAcquired(calendar.getTime());
		calendar.clear();
		calendar.set(2010, 00, 02);
	}
	public final Item itemDate2 = new Item("Date2", "Category", "Unit", "Status", "Condition");

	{
//		itemDate2.setDateAcquired(calendar.getTime());
	}

	@Before
	public void init() throws TransactionException {
		addAll();
		s = new ItemSearcher();
	}

	@Test
	public void searchItemName() throws TransactionException {
		List<Item> result = s.search("Item");

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

	@Test
	public void searchByDate() {

		List<Item> result = s.search("20100101"); // January 1, 2010

		assertEquals(1, result.size());
		assertTrue(result.contains(itemDate));
	}

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
		List<Item> result = s.search("Description");

		assertTrue(result.size() == 1);
		assertTrue(result.contains(item));
	}

	@After
	public void removeAll() throws TransactionException {
		im.removeItem(itemQuickBrownFox);
		im.removeItem(itemTermName);
		im.removeItem(itemDate2);
		im.removeItem(itemDate);
		im.removeItem(item2);
		im.removeItem(item);
		im.removeUnit(unit);
		im.removeItemCondition(condition);
		im.removeItemStatus(status);
		im.removeItemCategory(category);
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
