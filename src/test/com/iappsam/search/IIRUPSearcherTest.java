package com.iappsam.search;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.entities.EntityRemover;
import com.iappsam.forms.Disposal;
import com.iappsam.forms.IIRUP;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.IIRUPManagerSession;
import com.iappsam.managers.sessions.ItemManagerSession;

public class IIRUPSearcherTest {

	private static final String ITEM_DESCRIPTION = "description";

	private static IIRUPManager iirupm;
	private static ItemManager im;

	private static IIRUPSearcher searcher;
	private IIRUP iirup;

	@BeforeClass
	public static void initManager() throws TransactionException {
		iirupm = new IIRUPManagerSession();
		im = new ItemManagerSession();
		searcher = new IIRUPSearcher();
	}

	@Before
	public void initSearcher() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();

		Employee em = Employee.create("Dean", "Mr", "John");

		iirup = new IIRUP(Date.valueOf("2010-01-01"), em, em, em, em, em);
		iirup.setStation("station");

		Item item = Item.create(ITEM_DESCRIPTION, "cat", "unit", "st", "con");
		im.addItem(item);

		iirup.addLine(item, 1, 2, 1.0f, new Disposal("Disposal"), "0101");

		iirupm.addIIRUP(iirup);
	}

	@Test
	public void testIIRUPStation() {
		List<IIRUP> result = searcher.search("station");

		assertEquals(1, result.size());
		assertTrue(result.contains(iirup));
	}

	@Test
	public void testIIRUPDate() throws TransactionException {

		List<IIRUP> result = searcher.search("20100101");
		assertEquals(1, result.size());
		assertTrue(result.contains(iirup));
	}

	@Test
	public void testIIRUPItem() {
		List<IIRUP> result = searcher.search(ITEM_DESCRIPTION);
		assertEquals(1, result.size());
		assertTrue(result.contains(iirup));
	}
}
