package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;

public class PurchaseRequestTest {

	@Test
	public void shouldSucessValidateWithRequiredFields() {
		Employee requestedBy = Employee.create("des", "name");
		Employee approvedBy = Employee.create("des", "name");
		PurchaseRequest pr = new PurchaseRequest(new DivisionOffice("division", "office"), "purpose", requestedBy, approvedBy);
		assertTrue(pr.isValid());
	}
}
