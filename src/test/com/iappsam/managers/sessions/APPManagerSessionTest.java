package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Item;
import com.iappsam.entities.ItemFactory;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class APPManagerSessionTest {

	private PersonManager pm;
	private DivisionOfficeManager dom;

	private Person person;
	private Employee employee;
	private Signatory signatory;
	private DivisionOffice office;
	private AnnualProcurementPlan app;
	private APPManager appm;

	@Before
	public void addAPPDepedencies() throws TransactionException, DuplicateEntryException {
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

		appm = new APPManagerSession();
		app = new AnnualProcurementPlan(2011, office, signatory, signatory);
	}

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		appm.addAPP(app);

		assertExist();
	}

	private void assertExist() throws TransactionException {
		AnnualProcurementPlan appFromDb = appm.getAPP(app.getId());
		assertEquals(app, appFromDb);
	}

	@Test
	public void addAPPLine() throws TransactionException, DuplicateEntryException {

		appm.addAPP(app);

		Item item = ItemFactory.createPersistedItem("Item Description");
		AnnualProcurementPlanLine line1 = new AnnualProcurementPlanLine(item, 1, 2, 3, 4);
		app.addLine(line1);

		Item item2 = ItemFactory.createPersistedItem("Second Item Description");
		AnnualProcurementPlanLine line2 = new AnnualProcurementPlanLine(item2, 5, 6, 7, 8);
		app.addLine(line2);

		appm.addAPPLine(line1);
		appm.addAPPLine(line2);
		appm.updateAPP(app);

		assertAPPContains(line1, line2);

		appm.removeAPPLine(line1);
		appm.removeAPPLine(line2);
	}

	private void assertAPPContains(AnnualProcurementPlanLine line1, AnnualProcurementPlanLine line2) throws TransactionException {
		AnnualProcurementPlan appFromDb = appm.getAPP(app.getId());
		assertTrue(appFromDb.getLines().contains(line1));
		assertTrue(appFromDb.getLines().contains(line2));
	}

	@After
	public void removeAPPDependencies() throws TransactionException {
		appm.removeAPP(app);
		dom.removeDivisionOffice(office);
		pm.removeSignatory(signatory);
		pm.removeEmployee(employee);
		pm.removePerson(person);
	}
}
