package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
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

public class PersonManagerSessionTest extends ManagerSessionTestCase {

	private static PersonManagerSession pm;
	private static DivisionOfficeManager dom;

	private Person person;
	private Employee employee;
	private DivisionOffice divisionOffice;
	private ContactManager cm;
	private Contact contact;
	private Person person2;

	@BeforeClass
	public static void initClass() {
		pm = new PersonManagerSession();
		dom = new DivisionOfficeManagerSession();
	}

	@Override
	@Before
	public void init() throws Exception {
		EntityRemover.removeAccounts();
		EntityRemover.removeEmployees();
		EntityRemover.removePersons();
		EntityRemover.removeContacts();
		EntityRemover.removeDivisionOffices();

		person = new Person("John");
		employee = new Employee("Designation", person);
		divisionOffice = new DivisionOffice("Division", "Office");
		contact = new Contact("contact", ContactType.LANDLINE);
	}

	@Test
	public void shouldAddPerson() throws TransactionException, DuplicateEntryException {
		pm.addPerson(person);
		assertEquals(person, pm.getPerson(person));
	}

	@Test
	public void shouldAddEmployee() throws TransactionException, DuplicateEntryException {
		pm.addPerson(person);
		pm.addEmployee(employee);
		assertEquals(employee, pm.getEmployee(employee));
	}

	@Test
	public void shouldAddEmployeeWithDivisionOffice() throws TransactionException, DuplicateEntryException {
		employee.setDivisionOffice(divisionOffice);
		pm.addPerson(person);
		dom.addDivisionOffice(divisionOffice);
		pm.addEmployee(employee);

		assertEquals(employee, pm.getEmployee(employee));
	}

	@Test
	public void getEmployeeByName() throws TransactionException, DuplicateEntryException {
		Employee em = Employee.create("de", "mr", "john");
		pm.addEmployee(em);
		assertEquals(em, pm.getEmployeeByName("john"));
	}

	@Test
	public void shouldAddPersonWithContact() throws TransactionException, DuplicateEntryException {
		person.addContact(contact);
		pm.addPerson(person);
		assertEquals(person, pm.getPerson(person));
	}

	@Test
	public void shouldAddPersonWith2Contacts() throws TransactionException, DuplicateEntryException {
		Contact contact2 = new Contact("More Contact", ContactType.EMAIL);

		person.addContact(contact);
		person.addContact(contact2);

		pm.addPerson(person);

		assertEquals(person, pm.getPerson(person));
	}

	@Test
	public void shouldContainOnePerson() throws TransactionException, DuplicateEntryException {
		pm.addPerson(person);
		assertEquals(1, pm.getAllPersons().size());
	}

	@Test
	public void shouldUpdatePerson() throws TransactionException, DuplicateEntryException {
		pm.addPerson(person);
		person.setName("name updated");
		pm.updatePerson(person);
		assertEquals(person, pm.getPerson(person));
	}
}
