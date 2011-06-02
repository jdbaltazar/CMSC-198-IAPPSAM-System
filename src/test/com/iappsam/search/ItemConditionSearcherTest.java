package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.entities.ItemCondition;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.search.ItemConditionSearcher;

public class ItemConditionSearcherTest extends ItemManagerTestSuite {

	private static ItemConditionSearcher searcher;

	@BeforeClass
	public static void initSeacher() {
		searcher = new ItemConditionSearcher();
	}

	@Test
	public void searchConditionName() throws TransactionException {
		ItemCondition condition = new ItemCondition("Condition");
		im.addItemCondition(condition);

		List<ItemCondition> result = searcher.search("Condition");

		assertEquals(1, result.size());
		assertTrue(result.contains(condition));
	}
}
