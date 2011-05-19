package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.BasicItemEntities;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class SearchingTest {

	private ItemManager im = new ItemManagerSession();
	private BasicItemEntities entities = new BasicItemEntities(im);
	private Searcher s;

	@Before
	public void init() throws TransactionException {
		entities.addAll();
		s = new ItemSearcher();
	}

	@Test
	public void searchNonConsecutiveTerm() {
		List<Item> result = s.search("Quick Fox");

		assertEquals(1, result.size());
		assertTrue(result.contains(entities.itemQuickBrownFox));
	}

	@Test
	public void searchByDate() {

		List<Item> result = s.search("20100101"); // January 1, 2010

		assertEquals(1, result.size());
		assertTrue(result.contains(entities.itemDate));
	}

	@Test
	public void searchByDateRange() {
		List<Item> result = s.search("[20100101 TO 20100102]");

		assertEquals(2, result.size());
		assertTrue(result.contains(entities.itemDate));
		assertTrue(result.contains(entities.itemDate2));
	}

	@Test
	public void searchCaseInsensitive() {
		List<Item> result = s.search("SECOND");

		assertEquals(1, result.size());
		assertTrue(result.contains(entities.itemTermName));
	}

	@Test
	public void searchItemName() throws TransactionException {
		List<Item> result = s.search("Item");

		assertEquals(2, result.size());
		assertTrue(result.contains(entities.item));
		assertTrue(result.contains(entities.item2));

		im.removeItem(entities.item);
		im.removeItem(entities.item2);

		List<Item> result2 = s.search("Item");

		assertEquals(0, result2.size());
		assertTrue(!result2.contains(entities.item));
		assertTrue(!result2.contains(entities.item2));
	}

	@Test
	public void searchItemDescription() throws TransactionException {
		List<Item> result = s.search("Description");

		assertTrue(result.size() == 1);
		assertTrue(result.contains(entities.item));

		entities.im.removeItem(entities.item);
		List<Item> result2 = s.search("Description");

		assertTrue(result2.size() == 0);
		assertTrue(!result2.contains(entities.item));
	}

	@After
	public void removeEntities() throws TransactionException {
		entities.removeAllExisting();
	}
}
