package com.iappsam.entities;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.iappsam.Employee;
import com.iappsam.Supplier;

public class SupplierTest {

	@Test
	public void sameSupplier() {

		Supplier supplier1 = new Supplier("Supplier ABC", "Tacloban City", Employee.create("CEO", null, "Wong"));
		Supplier supplier2 = new Supplier("Supplier ABC", "Tacloban City", Employee.create("CEO", null, "Wong"));

		assertEquals(supplier1, supplier2);
	}
}
