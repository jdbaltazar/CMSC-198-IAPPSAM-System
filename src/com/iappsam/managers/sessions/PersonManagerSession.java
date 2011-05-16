package com.iappsam.managers.sessions;

import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.managers.Manager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSession extends Manager implements PersonManager {

	@Override
	public void addPerson(Person person) throws TransactionException {
		add(person);
	}

	@Override
	public int savePerson(Person person) throws TransactionException {
		return (Integer) save(person);
	}

	@Override
	public void updatePerson(Person person) throws TransactionException {
		update(person);
	}

	@Override
	public Person getPerson(int personId) throws TransactionException {
		return (Person) get(Person.class, personId);
	}

	@Override
	public void removePerson(Person person) throws TransactionException {
		remove(person);
	}

	@Override
	public boolean containsPerson(Person person) throws TransactionException {
		return contains(person);
	}

	@Override
	public boolean containsPerson(String name) throws TransactionException {
		List<Person> persons = getList(Person.class);
		for (Person p: persons) {
			if (p.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List<Person> getAllPersons() throws TransactionException {
		return getList(Person.class);
	}

	@Override
	public void addEmployee(Employee employee) throws TransactionException {
		add(employee);
	}

	@Override
	public int saveEmployee(Employee employee) throws TransactionException {
		return (Integer)save(employee);
	}

	@Override
	public void updateEmployee(Employee employee) throws TransactionException {
		update(employee);
	}

	@Override
	public Employee getEmployee(int employeeID) throws TransactionException {
		return (Employee)get(Employee.class, employeeID);
	}

	@Override
	public void removeEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		remove(employee);
	}

	@Override
	public boolean containsEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(employee);
	}
	
//	@Override
//	public List<Employee> getEmployeeByPerson(int personID) throws TransactionException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	@Override
	public List<Employee> getAllEmployee() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Employee.class);
	}
//
//	@Override
//	public boolean containsDesignation(String designation, int divisionOfficeID) throws TransactionException {
//		// TODO Auto-generated method stub
//		return false;
//	}

	@Override
	public void addSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		add(signatory);
	}

	@Override
	public int saveSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer)save(signatory);
	}

	@Override
	public void updateSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		update(signatory);
	}

	@Override
	public Signatory getSignatory(int signatoryID) throws TransactionException {
		// TODO Auto-generated method stub
		return (Signatory) get(Signatory.class, signatoryID);
	}

	@Override
	public boolean containsSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(signatory);
	}

	@Override
	public List<Signatory> getAllSignatories() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Signatory.class);
	}

//	@Override
//	public List<Signatory> getAllSignatoriesByPerson(int personID) throws TransactionException {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
