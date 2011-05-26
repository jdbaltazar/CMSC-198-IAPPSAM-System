package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.PurchaseRequest;
import com.iappsam.entities.forms.PurchaseRequestLine;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PRManagerSessionTest {

	private DivisionOffice divisionOffice;
	private DivisionOfficeManagerSession dom;
	private PersonManager pm;
	private Person person;
	private PRManager prm;
	private PurchaseRequest pr;
	private Employee employee;
	private Signatory signatory;

	@Before
	public void addPR() throws TransactionException, DuplicateEntryException {
		divisionOffice = new DivisionOffice("Division", "Office");
		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(divisionOffice);

		pm = new PersonManagerSession();
		person = new Person("Person");
		pm.addPerson(person);

		employee = new Employee("Dean", person);
		pm.addEmployee(employee);

		signatory = new Signatory("Description", employee);
		pm.addSignatory(signatory);
		prm = new PRManagerSession();
		pr = new PurchaseRequest(divisionOffice, "Purpose", signatory, signatory);
		prm.addPR(pr);
	}

	@Test
	public void PRAdded() throws TransactionException, DuplicateEntryException {
		assertPurchaseRequestAdded();
	}

	@Test
	public void PRwithLineAdded() throws TransactionException {
		assertPurchaseRequestAdded();

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("Cat");
		builder.addStatus("Status");
		builder.addUnit("Unit");
		builder.addCondition("Condition");
		builder.addItem("Description");
		builder.addToDatabase();
		PurchaseRequestLine line = new PurchaseRequestLine(1, builder.getItem());
		pr.addLine(line);

		prm.addPRLine(line);
		prm.updatePRLine(line);
		prm.updatePR(pr);

		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertTrue(prfromDb.getLines().contains(line));

		prm.removePRLine(line);
		builder.removeFromDatabase();
	}

	@After
	public void removePRandReferences() throws TransactionException {
		prm.removePR(pr);
		pm.removeSignatory(signatory);
		pm.removeEmployee(employee);
		pm.removePerson(person);

		dom.removeDivisionOffice(divisionOffice);
	}

	private void assertPurchaseRequestAdded() throws TransactionException {
		PurchaseRequest prfromDb = prm.getPR(pr.getId());
		assertEquals(pr, prfromDb);
	}
}
