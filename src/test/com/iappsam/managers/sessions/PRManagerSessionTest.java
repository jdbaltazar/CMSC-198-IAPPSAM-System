package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PRManagerSessionTest {

	private DivisionOffice divisionOffice;
	private DivisionOfficeManagerSession dom;
	private PRManager prm;
	private PurchaseRequest pr;
	private PersonManager pm;
	private ItemManager im;

	@Before
	public void addPR() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();
		prm = new PRManagerSession();
		pm = new PersonManagerSession();
		im = new ItemManagerSession();

		divisionOffice = new DivisionOffice("Division", "Office");
		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(divisionOffice);

		Employee requestedBy = Employee.create("Officer", "Ms.", "Maria");
		Employee approvedBy = Employee.create("Dean", "Mr.", "John");

		pm.addEmployee(requestedBy);
		pm.addEmployee(approvedBy);

		pr = new PurchaseRequest(divisionOffice, "Purpose", requestedBy, approvedBy);
	}

	@Test
	public void shouldAddPurchaseRequestRequiredFields() throws TransactionException {
		prm.addPR(pr);
		assertEquals(pr, prm.getPR(pr));
	}

	@Test
	public void shouldAddPurchaseRequestAllFields() throws TransactionException {
		pr.setPrNumber("PR Num");
		pr.setPrDate(Date.valueOf("2011-01-01"));
		pr.setSaiNumber("Sai Num");
		pr.setSaiDate(Date.valueOf("2011-01-01"));
		pr.setAlobsNumber("alob num");
		pr.setAlobsDate(Date.valueOf("2011-01-01"));

		prm.addPR(pr);

		assertEquals(pr, prm.getPR(pr));
	}

	@Test
	public void shouldAddPurchaseRequestWithLine() throws TransactionException {
		Item it = Item.create("desc", "cat", "unit", "stat", "con");
		im.addItem(it);
		pr.addLine(1, it);
		prm.addPR(pr);

		PurchaseRequest prdb = prm.getPR(pr);
		assertEquals(1, prdb.getLines().size());
	}
}
