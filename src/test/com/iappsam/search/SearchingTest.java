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

	@Before
	public void init() throws TransactionException {
		entities.addAll();
	}

	@Test
	public void searchItemName() throws TransactionException {
		Searcher s = new ItemSearcher();
		List<Item> result = s.search("Item");

		assertTrue(result.size() == 2);
		assertTrue(result.contains(entities.item));
		assertTrue(result.contains(entities.item2));

		im.removeItem(entities.item);
		im.removeItem(entities.item2);
		
		List<Item> result2 = s.search("Item");

		assertTrue(result2.size() == 0);
		assertTrue(!result2.contains(entities.item));
		assertTrue(!result2.contains(entities.item2));
	}

	@Test
	public void searchItemDescription() throws TransactionException {
		Searcher s = new ItemSearcher();
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
