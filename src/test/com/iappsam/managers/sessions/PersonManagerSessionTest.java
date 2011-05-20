package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSessionTest {

	private PersonManager pm;
	private Person p;
	private Employee e;
	private DivisionOfficeManager dom;
	private DivisionOffice office;

	@Before
	public void initPersonManager() {
		pm = new PersonManagerSession();
	}

	@Test
	public void addThenRemovePerson() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		removePersonThenAssert();
	}

	@Test
	public void addThenRemoveEmployee() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addEmployeeThenAssert();
		removeEmployeeThenAssert();
		removePersonThenAssert();
	}

	@Test
	public void addThenRemoveEmployeeWithDivision() throws TransactionException, DuplicateEntryException {

		addPersonThenAssert();
		addOfficeThenAssert();

		Employee e = new Employee("Designation", p);
		e.setDivisionOffice(office);

		pm.addEmployee(e);

		Employee employeeFromDb = pm.getEmployee(e.getId());

		assertEquals(e, employeeFromDb);
		assertEquals(p, employeeFromDb.getPerson());
		assertEquals(office, employeeFromDb.getDivisionOffice());

		pm.removeEmployee(e);
		assertFalse(pm.containsEmployee(e));

		removeDivisionThenAssert();
		removePersonThenAssert();
	}

	@After
	public void closeManager() {
		pm.close();
	}

	private void removeDivisionThenAssert() throws TransactionException {
		dom.removeDivisionOffice(office);
		assertFalse(dom.containsDivisionOffice(office));
	}

	private void addOfficeThenAssert() throws TransactionException {
		office = new DivisionOffice("Division", "Office");
		dom = new DivisionOfficeManagerSession();
		dom.addDivisionOffice(office);
		assertTrue(dom.containsDivisionOffice(office));
	}

	private void addPersonThenAssert() throws TransactionException, DuplicateEntryException {
		p = new Person("John");
		pm.addPerson(p);
		Person personFromDb = pm.getPerson(p.getId());
		assertEquals(p, personFromDb);
	}

	private void addEmployeeThenAssert() throws TransactionException, DuplicateEntryException {
		e = new Employee("Designation", p);
		pm.addEmployee(e);
		Employee employeeFromDb = pm.getEmployee(e.getId());
		assertEquals(e, employeeFromDb);
		assertEquals(p, employeeFromDb.getPerson());
		assertNull(employeeFromDb.getDivisionOffice());
	}

	private void removePersonThenAssert() throws TransactionException {
		pm.removePerson(p);
		assertFalse(pm.containsPerson(p));
	}

	private void removeEmployeeThenAssert() throws TransactionException {
		pm.removeEmployee(e);
		assertFalse(pm.containsEmployee(e));
	}
}
