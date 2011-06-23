package com.iappsam.search;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.Employee;
import com.iappsam.Supplier;
import com.iappsam.entities.EntityRemover;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.SupplierManagerSession;

public class SupplierSearcherTest {

	private SupplierSearcher searcher;
	private Supplier supplier;

	@Before
	public void init() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();

		searcher = new SupplierSearcher();
		supplier = new Supplier("suppName", "suppAddress", Employee.create("mayor", "john"));

		SupplierManager sm = new SupplierManagerSession();
		sm.addSupplier(supplier);
	}

	@Test
	public void searchSupplierName() {
		List<Supplier> search = searcher.search("suppName");
		assertTrue(search.contains(supplier));
	}

	@Test
	public void searchSupplierAddress() {
		List<Supplier> search = searcher.search("suppAddress");
		assertTrue(search.contains(supplier));
	}

	@Test
	public void searchContactPersonName() {
		List<Supplier> search = searcher.search("john");
		assertTrue(search.contains(supplier));
	}
}
