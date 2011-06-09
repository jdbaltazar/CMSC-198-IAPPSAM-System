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

	@Before
	public void init() throws Exception {
		super.init();
		su = new SupplierManagerSession();
		pm = new PersonManagerSession();

		contactPerson = Employee.create("designation", "title", "name");
		supplier = new Supplier("Supplier Name", "Address", contactPerson);
	}

	@Test
	public void addTwoSupplier() throws TransactionException, DuplicateEntryException {
		Supplier supplier2 = new Supplier("Name", "address2", contactPerson);

		su.addSupplier(supplier);
		su.addSupplier(supplier2);

		assertEquals(2, su.getAllSuppliers().size());
	}

	@Test
	public void addSupplier() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		assertSupplierAdded();

		assertEquals(contactPerson, supplier.getContactPerson());
		assertTrue(contactPerson.hasSuppliers());
		assertTrue(contactPerson.getSuppliers().contains(supplier));
	}


	@Test
	public void cascadeDeleteEmployeeOnSupplierRemoval() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		assertSupplierAdded();

		su.removeSupplier(supplier);
		assertEmployeeRemoved();
	}

	@Test
	public void employeeNotDeletedAfterOneSupplierRemoved() throws TransactionException, DuplicateEntryException {
		su.addSupplier(supplier);
		assertSupplierAdded();

		Supplier supplier2 = new Supplier("Supp", "Add", contactPerson);
		su.addSupplier(supplier2);

		su.removeSupplier(supplier);
		assertEmployeeNotRemoved();
	}

	private void assertEmployeeNotRemoved() throws TransactionException {
		Employee employeeFromDb = pm.getEmployee(contactPerson.getId());
		assertEquals(contactPerson, employeeFromDb);
	}

	private void assertEmployeeRemoved() throws TransactionException {
		Employee employeeFromDb = pm.getEmployee(contactPerson.getId());
		assertNull(employeeFromDb);
	}

	private void assertSupplierAdded() throws TransactionException {
		Supplier supplierFromDb = su.getSupplier(supplier.getId());
		assertEquals(supplier, supplierFromDb);
		assertEquals(contactPerson, supplierFromDb.getContactPerson());
	}
}
