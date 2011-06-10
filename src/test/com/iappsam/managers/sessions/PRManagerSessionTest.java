package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.SignatoryBuilder;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
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

	@Before
	public void addPR() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();
		prm = new PRManagerSession();
		pm = new PersonManagerSession();

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
	public void PRAdded() throws TransactionException {
		prm.addPR(pr);
		assertPurchaseRequestAdded();
	}

	@Test
	public void PRwithLineAdded() throws TransactionException, DuplicateEntryException {
		assertPurchaseRequestAdded();

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("Cat").addStatus("Status").addUnit("Unit").addCondition("Condition").addItem("Description").addToDatabase();
		pr.addLine(1, builder.getItem());
		prm.addPR(pr);

		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertEquals(1, prfromDb.getLines().size());
	}

	private void assertPurchaseRequestAdded() throws TransactionException {
		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertEquals(pr, prfromDb);
	}
}
