package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.DivisionOffice;
import com.iappsam.Employee;
import com.iappsam.Item;
import com.iappsam.Person;
import com.iappsam.Signatory;
import com.iappsam.entities.EntityRemover;
import com.iappsam.forms.APP;
import com.iappsam.forms.APPLine;
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
	private DivisionOffice office;
	private APP app;
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

		office = new DivisionOffice("Division", "Office");

		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);

		appManager = new APPManagerSession();
		app = new APP(2011, office, employee, employee);
		im = new ItemManagerSession();
	}

	@Test
	public void addAPP() throws TransactionException, DuplicateEntryException {

		appManager.addAPP(app);
		assertExist();
		appManager.removeAPP(app);
	}

	private void assertExist() throws TransactionException {
		APP appFromDb = appManager.getAPP(app.getId());
		assertEquals(app, appFromDb);
	}

	@Test
	public void addAPPWithLine() throws TransactionException, DuplicateEntryException {
		Item item = Item.create("desc", "cat", "unit", "stat", "con");
		im.addItem(item);

		APPLine line = new APPLine(app, item, 1, 2, 3, 4);
		app.addLine(line);
		appManager.addAPP(app);

		assertAPPContains(line);
	}

	private void assertAPPContains(APPLine line1) throws TransactionException {
		APP appFromDb = appManager.getAPP(app.getId());
		assertTrue(appFromDb.getLines().contains(line1));
	}

}
