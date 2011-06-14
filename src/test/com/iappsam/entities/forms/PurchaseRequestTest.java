package com.iappsam.entities.forms;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;

public class PurchaseRequestTest {

	private PurchaseRequest pr;

	@Before
	public void initPr() {
		Employee emp = Employee.create("des", "name");
		pr = new PurchaseRequest(new DivisionOffice("division", "office"), "purpose", emp, emp);

	}

	@Test
	public void shouldNotBeValidWithRequiredFields() {
		pr.addLine(0, Item.create("des", "cat", "unit", "stat", "con"));
		assertTrue(pr.validate());
	}

	@Test
	public void shoultNotBeValidWithoutLines() {
		assertFalse(pr.validate());
	}

	@Test
	public void shouldNullPrDateifNullOrEmptyPrNumber() {
		pr.setPrDate(new Date(1));
		assertNull(pr.getPrDate());
	}
}
