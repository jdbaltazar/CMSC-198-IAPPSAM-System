package com.iappsam.entities;

import static org.junit.Assert.*;

import org.junit.Test;

public class EmployeeTest {

	@Test
	public void sameEmployee() {
		Employee e = new Employee();
		e.setId(1);

		Employee e2 = new Employee();
		e2.setId(1);

		assertEquals(e, e2);
	}

	@Test
	public void hasSupplier() {
		Employee contactPerson = Employee.create("des", "title", "name");
		Supplier supplier = new Supplier();
		supplier.setContactPerson(contactPerson);

		assertTrue(contactPerson.hasSuppliers());
		assertEquals(1, contactPerson.getSuppliers().size());
		assertTrue(contactPerson.getSuppliers().contains(supplier));
	}

	@Test
	public void containsSupplier() {
		Employee employee = new Employee();
		Supplier supplier = new Supplier();
		employee.addSupplier(supplier);

		assertTrue(employee.getSuppliers().contains(supplier));
	}

	@Test
	public void removeSupplier() {
		Employee employee = new Employee();
		Supplier supplier = new Supplier();
		employee.addSupplier(supplier);
		employee.removeSupplier(supplier);

		
		assertEquals(0 , employee.getSuppliers().size());
	}
}
