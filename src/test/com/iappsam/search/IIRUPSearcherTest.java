package com.iappsam.search;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.forms.Disposal;
import com.iappsam.entities.forms.IIRUP;
import com.iappsam.managers.IIRUPManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.IIRUPManagerSession;

public class IIRUPSearcherTest {

	private static final String ITEM_DESCRIPTION = "description";

	private static IIRUPManager iirupm;
	private IIRUPSearcher searcher;
	private IIRUP iirup;

	@BeforeClass
	public static void initManager() throws TransactionException {
		iirupm = new IIRUPManagerSession();
	}

	@Before
	public void initSearcher() throws TransactionException {
		EntityRemover.removeIIRUPs();
		EntityRemover.removeItems();
		EntityRemover.removeItemDependencies();
		EntityRemover.removeEmployees();

		searcher = new IIRUPSearcher();
		Employee em = Employee.create("Dean", "Mr", "John");

		iirup = new IIRUP(Date.valueOf("2010-01-01"), em, em, em, em, em);
		iirup.setStation("station");

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("cat").addCondition("con").addStatus("stat").addUnit("unit").addItem(ITEM_DESCRIPTION);
		builder.addToDatabase();

		iirup.addLine(builder.getItem(), 1, 2, 1.0f, new Disposal("Disposal"), "0101");

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