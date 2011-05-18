package com.iappsam.search;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Item;
import com.iappsam.entities.BasicItemEntities;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.ItemManagerSession;

public class SearchingTest {

	BasicItemEntities itemEntities = new BasicItemEntities(new ItemManagerSession());

	@Before
	public void init() throws TransactionException {
		itemEntities.addAll();
	}

	@Test
	public void searchItemName() throws TransactionException {
		Searcher s = new ItemSearcher();
		List<Item> result = s.search("Item");
		assertTrue(result.size() == 1);
		assertTrue(result.contains(itemEntities.getItem()));

		itemEntities.removeItem();
		List<Item> result2 = s.search("Item");
		assertTrue(result2.size() == 0);
		assertTrue(!result2.contains(itemEntities.getItem()));
	}

	@Test
	public void searchItemDescription() throws TransactionException {
		Searcher s = new ItemSearcher();
		List<Item> result = s.search("Description");
		assertTrue(result.size() == 1);
		assertTrue(result.contains(itemEntities.getItem()));

		itemEntities.removeItem();
		List<Item> result2 = s.search("Description");
		assertTrue(result2.size() == 0);
		assertTrue(!result2.contains(itemEntities.getItem()));
	}

	@After
	public void removeEntities() throws TransactionException {
		itemEntities.removeAllIfExist();
	}
}
