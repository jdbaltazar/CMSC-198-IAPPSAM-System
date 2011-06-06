package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.SignatoryBuilder;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PRManagerSessionTest {

	private DivisionOffice divisionOffice;
	private DivisionOfficeManagerSession dom;
	private PRManager prm;
	private PurchaseRequest pr;
	private SignatoryBuilder signatorybuilder;

	@Before
	public void addPR() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();

		divisionOffice = new DivisionOffice("Division", "Office");
		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(divisionOffice);

		Signatory signatory = buildAndGetSignatory();

		prm = new PRManagerSession();
		pr = new PurchaseRequest(divisionOffice, "Purpose", signatory, signatory);
	}

	@Test
	public void PRAdded() throws TransactionException, DuplicateEntryException {
		prm.addPR(pr);
		assertPurchaseRequestAdded();
	}

	@Test
	public void PRwithLineAdded() throws TransactionException, DuplicateEntryException {
		assertPurchaseRequestAdded();

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("Cat").addStatus("Status").addUnit("Unit").addCondition("Condition").addItem("Description").addToDatabase();
		PurchaseRequestLine line = new PurchaseRequestLine(1, builder.getItem());
		pr.addLine(line);
		prm.addPR(pr);

		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertTrue(prfromDb.getLines().contains(line));

		builder.removeFromDatabase();
	}

	private Signatory buildAndGetSignatory() throws TransactionException, DuplicateEntryException {
		signatorybuilder = new SignatoryBuilder();
		signatorybuilder.addPerson("Person").addEmployee("Dean").addSignatory("Description").addToDatabase();
		Signatory signatory = signatorybuilder.getSignatory();
		return signatory;
	}

	private void assertPurchaseRequestAdded() throws TransactionException {
		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertEquals(pr, prfromDb);
	}
}
