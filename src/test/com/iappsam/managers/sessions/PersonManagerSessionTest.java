package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.ContactManager;
import com.iappsam.managers.DivisionOfficeManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSessionTest {

	private PersonManagerSession pm;
	private Person person;
	private Employee employee;
	private DivisionOfficeManager dom;
	private DivisionOffice divisionOffice;

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
	public void addPerson() throws TransactionException, DuplicateEntryException {
		Person person = new Person("John");
		pm.addPerson(person);
		assertTrue(pm.containsPerson(person));
		pm.removePerson(person);
	}

	@Test
	public void addPersonWithContact() throws TransactionException, DuplicateEntryException {
		Contact contact = new Contact("contact", ContactType.LANDLINE);
		ContactManager cm = new ContactManagerSession();
		cm.addContact(contact);

		Person person = new Person("Maria");
		pm.addPerson(person);

		person.addContact(contact);
		pm.updatePerson(person);

		Person personFromDb = pm.getPerson(person.getId());
		assertTrue(personFromDb.getContacts().contains(contact));

		person.removeContact(contact);
		pm.updatePerson(person);
		pm.removePerson(person);

		cm.removeContact(contact);
	}

	@Test
	public void addThenRemoveEmployeeWithDivisionOffice() throws TransactionException, DuplicateEntryException {

		addPersonThenAssert();
		addOfficeThenAssert();

		Employee e = new Employee("Designation", person);
		e.setDivisionOffice(divisionOffice);

		pm.addEmployee(e);

		Employee employeeFromDb = pm.getEmployee(e.getId());

		assertEquals(e, employeeFromDb);
		assertEquals(person, employeeFromDb.getPerson());
		assertEquals(divisionOffice, employeeFromDb.getDivisionOffice());

		pm.removeEmployee(e);
		assertFalse(pm.containsEmployee(e));

		removeDivisionThenAssert();
		removePersonThenAssert();
	}

	private void removeDivisionThenAssert() throws TransactionException {
		dom.removeDivisionOffice(divisionOffice);
		assertFalse(dom.containsDivisionOffice(divisionOffice));
	}

	private void addOfficeThenAssert() throws TransactionException, DuplicateEntryException {
		dom = new DivisionOfficeManagerSession();
		divisionOffice = new DivisionOffice("Division", "Office");
		dom.addDivisionOffice(divisionOffice);

		DivisionOffice doFromDb = dom.getDivisionOffice(divisionOffice.getId());
		assertEquals(divisionOffice, doFromDb);
	}

	private void addPersonThenAssert() throws TransactionException, DuplicateEntryException {
		person = new Person("John");
		pm.addPerson(person);
		Person personFromDb = pm.getPerson(person.getId());
		assertEquals(person, personFromDb);
	}

	private void addEmployeeThenAssert() throws TransactionException, DuplicateEntryException {
		employee = new Employee("Designation", person);
		pm.addEmployee(employee);
		Employee employeeFromDb = pm.getEmployee(employee.getId());
		assertEquals(employee, employeeFromDb);
		assertEquals(person, employeeFromDb.getPerson());
		assertNull(employeeFromDb.getDivisionOffice());
	}

	private void removePersonThenAssert() throws TransactionException {
		pm.removePerson(person);
		assertFalse(pm.containsPerson(person));
	}

	private void removeEmployeeThenAssert() throws TransactionException {
		pm.removeEmployee(employee);
		assertFalse(pm.containsEmployee(employee));
	}
}
