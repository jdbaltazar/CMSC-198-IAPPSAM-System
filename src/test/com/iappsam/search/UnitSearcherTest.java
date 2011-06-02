package com.iappsam.search;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.entities.Unit;
import com.iappsam.managers.exceptions.TransactionException;

public class UnitSearcherTest extends ItemManagerTestSuite {

	private static UnitSearcher searcher;

	@BeforeClass
	public static void initSearcher() {
		searcher = new UnitSearcher();
	}

	@Test
	public void searchCategory() throws TransactionException {
		Unit unit = new Unit("Unit");
		im.addUnit(unit);

		List<Unit> result = searcher.search("Unit");

		assertEquals(1, result.size());
		assertTrue(result.contains(unit));
	}
}
