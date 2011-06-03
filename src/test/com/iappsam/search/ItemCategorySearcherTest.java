package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.entities.ItemCategory;
import com.iappsam.managers.exceptions.TransactionException;

public class ItemCategorySearcherTest extends ItemManagerTestSuite {

	private static ItemCategorySearcher searcher;

	@BeforeClass
	public static void initSearcher() {
		searcher = new ItemCategorySearcher();
	}

	@Test
	public void searchCategory() throws TransactionException {
		ItemCategory category = new ItemCategory("Category");
		im.addItemCategory(category);

		List<ItemCategory> result = searcher.search("Category");

		assertEquals(1, result.size());
		assertTrue(result.contains(category));
	}

}
