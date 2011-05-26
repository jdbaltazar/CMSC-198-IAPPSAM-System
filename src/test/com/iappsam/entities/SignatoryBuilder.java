package com.iappsam.entities;

import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.managers.sessions.PersonManagerSession;

public class SignatoryBuilder {

	private Person person;
	private Employee employee;
	private Signatory signatory;
	private PersonManager pm = new PersonManagerSession();

	public SignatoryBuilder addPerson(String name) {
		person = new Person(name);
		return this;
	}

	public SignatoryBuilder addEmployee(String name) {

		if (person == null)
			throw new IllegalStateException();

		employee = new Employee(name, person);
		return this;
	}

	public SignatoryBuilder addSignatory(String description) {

		if (employee == null)
			throw new IllegalStateException();

		signatory = new Signatory(description, employee);
		return this;
	}

	public void addToDatabase() throws TransactionException, DuplicateEntryException {
		if (person == null || employee == null || signatory == null)
			throw new IllegalStateException();

		pm.addPerson(person);
		pm.addEmployee(employee);
		pm.addSignatory(signatory);
	}
	
	public void removeFromDatabase() throws TransactionException {
		pm.removeSignatory(signatory);
		pm.removeEmployee(employee);
		pm.removePerson(person);
	}

	public Person getPerson() {
		return person;
	}

	public Employee getEmployee() {
		return employee;
	}

	public Signatory getSignatory() {
		return signatory;
	}

}
