package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.iappsam.entities.Contact;
import com.iappsam.entities.ContactType;
import com.iappsam.entities.DivisionOffice;
import com.iappsam.entities.Employee;
import com.iappsam.entities.EntityRemover;
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
	private ContactManager cm;
	private Contact contact;
	private Person person2;

	@Before
	public void initPersonManager() throws TransactionException {
		EntityRemover.removeAll();
		pm = new PersonManagerSession();
	}

	@Test
	public void addThenRemovePerson() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
	}

	@Test
	public void addThenRemoveEmployee() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addEmployeeThenAssert();
	}

	@Test
	public void exactlyOneEmployee() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addEmployeeThenAssert();

		assertExactlyOneEmployeeInDatabase();
	}

	@Test
	public void exactlyOneEmployeeWithDivision() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addOfficeThenAssert();
		addEmployeeWithDivisionThenAssert();

		assertExactlyOneEmployeeInDatabase();
	}

	@Test
	public void addPerson() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
	}

	@Test
	public void addPersonWithContactThenRemoveCascade() throws TransactionException, DuplicateEntryException {
		addPersonWithContact();
		assertPersonWithContactExistInDatabase();
	}

	@Test
	public void exactlyOnePersonInDatabase() throws TransactionException, DuplicateEntryException {
		addPersonWithContact();
		assertPersonWithContactExistInDatabase();

		assertOnePersonInDatabase();
	}

	@Test
	public void addThenRemoveEmployeeWithDivisionOffice() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addOfficeThenAssert();
		addEmployeeWithDivisionThenAssert();
	}

	private void assertExactlyOneEmployeeInDatabase() throws TransactionException {
		assertEquals(1, pm.getAllEmployee().size());
	}

	private void addEmployeeWithDivisionThenAssert() throws TransactionException, DuplicateEntryException {
		employee = new Employee("Designation", person);
		employee.setDivisionOffice(divisionOffice);

		pm.addEmployee(employee);

		Employee employeeFromDb = pm.getEmployee(employee.getId());

		assertEquals(employee, employeeFromDb);
		assertEquals(person, employeeFromDb.getPerson());
		assertEquals(divisionOffice, employeeFromDb.getDivisionOffice());
	}

	private void removeOtherPersonWithContact() throws TransactionException {
		pm.removePerson(person2);
	}

	private void assertOtherPersonWithContactExistInDatbase() throws TransactionException {
		Person personFromDb = pm.getPerson(person2.getId());
		assertTrue(personFromDb.getContacts().contains(contact));
	}

	private void addAnotherPersonWithExistingContact() throws TransactionException, DuplicateEntryException {
		person2 = new Person("Maria");
		person2.addContact(contact);
		pm.addPerson(person2);
	}

	private void assertOnePersonInDatabase() throws TransactionException {
		assertEquals(1, pm.getAllPersons().size());
	}

	private void assertPersonWithContactExistInDatabase() throws TransactionException {
		Person personFromDb = pm.getPerson(person.getId());
		assertTrue(personFromDb.getContacts().contains(contact));
	}

	private void removePerson() throws TransactionException {
		pm.removePerson(person);
	}

	private void addPersonWithContact() throws TransactionException, DuplicateEntryException {
		person = new Person("Maria");
		contact = new Contact("contact", ContactType.LANDLINE);
		person.addContact(contact);
		pm.addPerson(person);
	}

	private void removeContact() throws TransactionException {
		cm.removeContact(contact);
	}

	private void addContact() throws TransactionException {
		contact = new Contact("contact", ContactType.LANDLINE);
		cm = new ContactManagerSession();
		cm.addContact(contact);
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
