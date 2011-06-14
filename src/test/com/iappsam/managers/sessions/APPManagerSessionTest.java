package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
import com.iappsam.entities.Item;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.ItemManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class APPManagerSessionTest {

	private PersonManager pm;
	private DivisionOfficeManager dom;

	private Person person;
	private Employee employee;
	private Signatory signatory;
	private DivisionOffice office;
	private AnnualProcurementPlan app;
	private APPManager appManager;
	private ItemManager im;

	@Before
	public void addAPPDepedencies() throws TransactionException, DuplicateEntryException {
		EntityRemover.removeAll();

		person = new Person("John");
		pm = new PersonManagerSession();
		pm.addPerson(person);

		employee = new Employee("Mayor", person);
		pm.addEmployee(employee);

		signatory = new Signatory("Signatory", employee);
		pm.addSignatory(signatory);

		office = new DivisionOffice("Division", "Office");

		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);

		appManager = new APPManagerSession();
		app = new AnnualProcurementPlan(2011, office, signatory, signatory);
		im = new ItemManagerSession();
	}

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		appManager.addAPP(app);
		assertExist();
		appManager.removeAPP(app);
	}

	private void assertExist() throws TransactionException {
		AnnualProcurementPlan appFromDb = appManager.getAPP(app.getId());
		assertEquals(app, appFromDb);
	}

	@Test
	public void addAPPWithLine() throws TransactionException, DuplicateEntryException {
		Item item = Item.create("desc", "cat", "unit", "stat", "con");
		im.addItem(item);

		AnnualProcurementPlanLine line = new AnnualProcurementPlanLine(app, item, 1, 2, 3, 4);
		app.addLine(line);
		appManager.addAPP(app);

		assertAPPContains(line);
	}

	private void assertAPPContains(AnnualProcurementPlanLine line1) throws TransactionException {
		AnnualProcurementPlan appFromDb = appManager.getAPP(app.getId());
		assertTrue(appFromDb.getLines().contains(line1));
	}

}
