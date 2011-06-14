package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Supplier;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.SupplierManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class SupplierManagerSessionTest extends ManagerSessionTestCase {

	private SupplierManager su;
	private Employee contactPerson;
	private Supplier supplier;
	private PersonManager pm;

	@Override
	@Before
	public void init() throws Exception {
		super.init();
		su = new SupplierManagerSession();
		pm = new PersonManagerSession();

		contactPerson = Employee.create("designation", "title", "name");
		supplier = new Supplier("Supplier Name", "Address", contactPerson);
	}

	@Test
	public void shouldContain2Suppliers() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		su.addSupplier(new Supplier("Name", "address2", contactPerson));

		assertEquals(2, su.getAllSuppliers().size());
	}

	@Test
	public void addSupplier() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		assertEquals(supplier, su.getSupplier(supplier));
	}

	@Test
	public void employeeNotDeletedAfterOneSupplierRemoved() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		su.addSupplier(new Supplier("Supp", "Add", contactPerson));
		su.removeSupplier(supplier);

		assertEquals(contactPerson, pm.getEmployee(contactPerson));
	}
}
