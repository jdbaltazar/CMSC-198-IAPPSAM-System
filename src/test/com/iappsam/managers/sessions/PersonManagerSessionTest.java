package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
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

public class PersonManagerSessionTest extends ManagerSessionTestCase {

	private static PersonManagerSession pm;
	private Person person;
	private Employee employee;
	private DivisionOfficeManager dom;
	private DivisionOffice divisionOffice;
	private ContactManager cm;
	private Contact contact;
	private Person person2;

	@BeforeClass
	public static void initClass() {
		pm = new PersonManagerSession();
	}

	@Override
	@Before
	public void init() throws Exception {
		super.init();
	}

	@Test
	public void testAddPerson() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
	}

	@Test
	public void addEmployee() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addEmployeeThenAssert();
	}

	@Test
	public void addEmployeeWithDivision() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addOfficeThenAssert();
		addEmployeeWithDivisionThenAssert();
	}

	@Test
	public void getEmployeeByName() throws TransactionException, DuplicateEntryException {
		Employee em = Employee.create("de", "mr", "john");
		pm.addEmployee(em);
		assertEquals(em, pm.getEmployeeByName("john"));
	}

	@Test
	public void addPersonInDatabase() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
	}

	@Test
	public void testAddPersonWithContact() throws TransactionException, DuplicateEntryException {
		addPersonWithContact();
		assertPersonWithContactExistInDatabase();
	}

	@Test
	public void addPersonWith2Contacts() throws TransactionException, DuplicateEntryException {
		person = new Person("Maria");
		contact = new Contact("contact", ContactType.LANDLINE);

		Contact contact2 = new Contact("More Contact", ContactType.EMAIL);

		person.addContact(contact);
		person.addContact(contact2);

		pm.addPerson(person);

		assertEquals(1, pm.getAllPersons().size());
		Person personFromDb = pm.getPerson(person.getId());
		assertTrue(personFromDb.getContacts().contains(contact));
		assertTrue(personFromDb.getContacts().contains(contact2));
	}

	@Test
	public void exactlyOnePersonInDatabase() throws TransactionException, DuplicateEntryException {
		addPersonWithContact();
		assertPersonWithContactExistInDatabase();
		assertOnePersonInDatabase();
	}

	@Test
	public void addEmployeeWithDivisionOffice() throws TransactionException, DuplicateEntryException {
		addPersonThenAssert();
		addOfficeThenAssert();
		addEmployeeWithDivisionThenAssert();
	}

	private void addPersonWithContact() throws TransactionException, DuplicateEntryException {
		person = new Person("Maria");
		contact = new Contact("contact", ContactType.LANDLINE);
		person.addContact(contact);
		pm.addPerson(person);
	}

	private void addEmployeeWithDivisionThenAssert() throws TransactionException, DuplicateEntryException {
		employee = new Employee("Designation", person);
		employee.setDivisionOffice(divisionOffice);

		pm.addEmployee(employee);

		Employee employeeFromDb = pm.getEmployee(employee.getId());

		assertEquals(1, pm.getAllEmployee().size());
		assertEquals(employee, employeeFromDb);
		assertEquals(person, employeeFromDb.getPerson());
		assertEquals(divisionOffice, employeeFromDb.getDivisionOffice());
	}

	private void assertOnePersonInDatabase() throws TransactionException {
		assertEquals(1, pm.getAllPersons().size());
	}

	private void assertPersonWithContactExistInDatabase() throws TransactionException {
		assertEquals(1, pm.getAllPersons().size());
		Person personFromDb = pm.getPerson(person.getId());
		assertTrue(personFromDb.getContacts().contains(contact));
	}

	private void addOfficeThenAssert() throws TransactionException, DuplicateEntryException {
		dom = new DivisionOfficeManagerSession();
		divisionOffice = new DivisionOffice("Division", "Office");
		dom.addDivisionOffice(divisionOffice);

		DivisionOffice doFromDb = dom.getDivisionOffice(divisionOffice.getId());
		assertEquals(divisionOffice, doFromDb);
	}

	private void addPersonThenAssert() throws TransactionException, DuplicateEntryException {
		addPerson();
		assertPersonInDatabase();
	}

	private void addPerson() throws TransactionException, DuplicateEntryException {
		person = new Person("John");
		pm.addPerson(person);
	}

	private void assertPersonInDatabase() throws TransactionException {
		assertEquals(1, pm.getAllPersons().size());
		Person personFromDb = pm.getPerson(person.getId());
		assertEquals(person, personFromDb);
	}

	private void addEmployeeThenAssert() throws TransactionException, DuplicateEntryException {
		employee = new Employee("Designation", person);
		pm.addEmployee(employee);

		assertEquals(1, pm.getAllEmployee().size());
		Employee employeeFromDb = pm.getEmployee(employee.getId());
		assertEquals(employee, employeeFromDb);
		assertEquals(person, employeeFromDb.getPerson());
		assertNull(employeeFromDb.getDivisionOffice());
	}

}
