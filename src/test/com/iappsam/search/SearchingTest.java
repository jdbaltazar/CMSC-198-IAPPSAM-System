package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.ItemCondition;
import com.iappsam.entities.ItemStatus;
import com.iappsam.entities.Unit;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class SearchingTest {

	private ItemManager im = new ItemManagerSession();
	private Searcher s;

	public final ItemCondition condition = new ItemCondition("");
	public final ItemStatus status = new ItemStatus("");
	public final Unit unit = new Unit("");

	public final Item item = new Item("Item", "", "Description", 0.0f, new Date(0), "", "");
	public final Item item2 = new Item("Item Again", "", "Description2", 0.0f, new Date(0), "", "");
	public final Item itemQuickBrownFox = new Item("Quick Brown Fox", "", "", 0.0f, new Date(0), "", "");
	public final Item itemTermName = new Item("Second Test", "", "Description2 Test", 0.0f, new Date(0), "", "");

	private final Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
	{
		calendar.clear();
		calendar.set(2010, 00, 01);
	}
	public final Item itemDate = new Item("", "", "", 0.0f, calendar.getTime(), "", "");
	{
		calendar.clear();
		calendar.set(2010, 00, 02);
	}
	public final Item itemDate2 = new Item("", "", "", 0.0f, calendar.getTime(), "", "");

	private void addAll() throws TransactionException {
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

	private void removeAllExisting() throws TransactionException {
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
			im.removeUnit(unit);

		if (im.containsItemCondition(condition))
			im.removeItemCondition(condition);

		if (im.containsItemStatus(status))
			im.removeItemStatus(status);
	}

	@Before
	public void init() throws TransactionException {
		addAll();
		s = new ItemSearcher();
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
	public void searchItemName() throws TransactionException {
		List<Item> result = s.search("Item");

		assertEquals(2, result.size());
		assertTrue(result.contains(item));
		assertTrue(result.contains(item2));

		im.removeItem(item);
		im.removeItem(item2);

		List<Item> result2 = s.search("Item");

		assertEquals(0, result2.size());
		assertTrue(!result2.contains(item));
		assertTrue(!result2.contains(item2));
	}

	@Test
	public void searchItemDescription() throws TransactionException {
		List<Item> result = s.search("Description");

		assertTrue(result.size() == 1);
		assertTrue(result.contains(item));

		im.removeItem(item);
		List<Item> result2 = s.search("Description");

		assertTrue(result2.size() == 0);
		assertTrue(!result2.contains(item));
	}

	@After
	public void removeAllAndClose() throws TransactionException {
		removeAllExisting();
		im.close();
	}

}