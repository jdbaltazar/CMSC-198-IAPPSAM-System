package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;

public class PurchaseRequestTest {

	@Test
	public void samePR() {
		PurchaseRequest pr = new PurchaseRequest();
		pr.setId(1);

		PurchaseRequest pr2 = new PurchaseRequest();
		pr2.setId(1);

		assertEquals(pr, pr2);
	}

	@Test
	public void shouldSucessValidateOnRequiredFields() {
		PurchaseRequest pr = new PurchaseRequest(new DivisionOffice("division", "office"), "purpose", Employee.create("des", "name"), Employee.create(
				"des", "name"));
		assertTrue(pr.isValid());
	}
}
