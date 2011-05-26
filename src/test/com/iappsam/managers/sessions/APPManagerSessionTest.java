package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.ItemBuilder;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.entities.forms.AnnualProcurementPlan;
import com.iappsam.entities.forms.AnnualProcurementPlanLine;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.DivisionOfficeManager;
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

		appManager = new APPManagerSession();
		app = new AnnualProcurementPlan(2011, office, signatory, signatory);
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

		appManager.addAPP(app);

		ItemBuilder builder = new ItemBuilder();
		builder.addCategory("Cat");
		builder.addStatus("Status");
		builder.addUnit("Unit");
		builder.addCondition("Condition");
		builder.addItem("Description");
		builder.addToDatabase();

		AnnualProcurementPlanLine line1 = new AnnualProcurementPlanLine(builder.getItem(), 1, 2, 3, 4);
		app.addLine(line1);

		ItemBuilder builder2 = new ItemBuilder();
		builder2.addCategory("Cat2");
		builder2.addStatus("Status2");
		builder2.addUnit("Unit2");
		builder2.addCondition("Condition2");
		builder2.addItem("Description2");
		builder2.addToDatabase();

		AnnualProcurementPlanLine line2 = new AnnualProcurementPlanLine(builder2.getItem(), 5, 6, 7, 8);
		app.addLine(line2);

		appManager.addAPPLine(line1);
		appManager.addAPPLine(line2);
		appManager.updateAPP(app);

		assertAPPContains(line1, line2);

		appManager.removeAPPLine(line1);
		appManager.removeAPPLine(line2);
		appManager.removeAPP(app);

		builder.removeFromDatabase();
		builder2.removeFromDatabase();
	}

	private void assertAPPContains(AnnualProcurementPlanLine line1, AnnualProcurementPlanLine line2) throws TransactionException {
		AnnualProcurementPlan appFromDb = appManager.getAPP(app.getId());
		assertTrue(appFromDb.getLines().contains(line1));
		assertTrue(appFromDb.getLines().contains(line2));
	}

	@After
	public void removeAPPDependencies() throws TransactionException {
		dom.removeDivisionOffice(office);
		pm.removeSignatory(signatory);
		pm.removeEmployee(employee);
		pm.removePerson(person);
	}
}
