package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.entities.ItemStatus;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemStatusSearcherTest extends ItemManagerTestSuite {

	private static ItemStatusSearcher searcher;

	@BeforeClass
	public static void initSearcher() {
		searcher = new ItemStatusSearcher();
	}

	@Test
	public void searchItemStatusName() throws TransactionException, DuplicateEntryException {
		ItemStatus status = new ItemStatus("st");
		im.addItemStatus(status);

		List<ItemStatus> result = searcher.search("st");

		assertEquals(1, result.size());
		assertTrue(result.contains(status));
	}
}
