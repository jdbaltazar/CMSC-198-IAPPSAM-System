package com.iappsam.managers.sessions;

import static org.junit.Assert.*;

import org.junit.Test;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSessionTest {

	@Test
	public void addThenRemovePerson() throws TransactionException, DuplicateEntryException {
		PersonManager pm = new PersonManagerSession();

		Person p = new Person("John");

		pm.addPerson(p);
		assertTrue(pm.containsPerson(p));

		pm.removePerson(p);
		assertFalse(pm.containsPerson(p));
	}

	@Test
	public void addThenRemoveEmployee() throws TransactionException, DuplicateEntryException {
		PersonManager pm = new PersonManagerSession();

		Person p = new Person("John");

		pm.addPerson(p);
		assertTrue(pm.containsPerson(p));

		Employee e = new Employee("Designation", p);

		pm.addEmployee(e);
		assertTrue(pm.containsEmployee(e));
		assertEquals(p, e.getPerson());

		pm.removeEmployee(e);
		assertFalse(pm.containsEmployee(e));

		pm.removePerson(p);
		assertFalse(pm.containsPerson(p));
	}
}
