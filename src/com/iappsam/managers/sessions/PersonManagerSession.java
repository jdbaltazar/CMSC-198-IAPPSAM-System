package com.iappsam.managers.sessions;

import java.util.Iterator;
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
		return (Integer)save(person);
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
		List persons = getList();
		for (Iterator iter = persons.iterator(); iter.hasNext();) {
			Person p = (Person) (iter.next());
			if (p.getName().equalsIgnoreCase(name))
				return true;
		}
		return false;
	}

	@Override
	public List getAllPersons() throws TransactionException {
		return getList();
		// TODO Auto-generated method stub
	}

	@Override
	public void addEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Employee getEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean containsEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsDesignation(String designation, int divisionOfficeID) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getAllEmployee() throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Employee> getAllEmployment(int personID) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int saveSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void updateSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Signatory getSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean containsSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Signatory> getAllSignatories() throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Signatory> getAllSignatoriesByPerson(int personID) throws TransactionException {
		// TODO Auto-generated method stub
		return null;
	}


}
