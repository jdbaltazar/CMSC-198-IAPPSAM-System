package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import com.iappsam.entities.Employee;
import com.iappsam.entities.EmployeeDivisionOffice;
import com.iappsam.entities.Person;
import com.iappsam.entities.Signatory;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public class PersonManagerSession extends AbstractManager implements PersonManager {

	@Override
	public void addPerson(Person person) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (!contains(person.getName()))
			add(person);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public int savePerson(Person person) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (!contains(person.getName()))
			return (Integer) save(person);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void updatePerson(Person person) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (!containsPerson(person.getName()))
			update(person);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public Person getPerson(int personId) throws TransactionException {
		// TODO Auto-generated method stub
		return (Person) get(Person.class, personId);
	}

	@Override
	public Person getPerson(String name) throws TransactionException {
		// TODO Auto-generated method stub
		List<Person> persons = getAllPersons();
		for (Person p : persons) {
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}

	@Override
	public void removePerson(Person person) throws TransactionException {
		// TODO Auto-generated method stub
		remove(person);
	}

	@Override
	public boolean containsPerson(Person person) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(person);
	}

	@Override
	public boolean containsPerson(String name) throws TransactionException {
		// TODO Auto-generated method stub
		if (getPerson(name) != null) {
			return true;
		}
		return false;
	}

	@Override
	public List<Person> getAllPersons() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Person.class);
	}

	@Override
	public List<Person> getPersonByDivisionOffice(int divisionOfficeId) throws TransactionException {
		// TODO Auto-generated method stub
		List<Person> result = new ArrayList<Person>();
		List<EmployeeDivisionOffice> employeeDivisionOffices = getAllEmployeeDivisionOffice();
		for (EmployeeDivisionOffice emDivisionOffice : employeeDivisionOffices) {
			if (emDivisionOffice.getDivisionOfficeID() == divisionOfficeId) {
				Employee emp = getEmployee(emDivisionOffice.getEmployeeID());
				Person p = getPerson(emp.getPersonID());
				if (!result.contains(p))
					result.add(p);
			}
		}
		return result;
	}

	@Override
	public List<EmployeeDivisionOffice> getAllEmployeeDivisionOffice() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(EmployeeDivisionOffice.class);
	}

	@Override
	public void addEmployee(Employee employee) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (!contains(employee))
			add(employee);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public int saveEmployee(Employee employee) throws TransactionException, DuplicateEntryException {
		// TODO Auto-generated method stub
		if (!contains(employee))
			return (Integer) save(employee);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public void updateEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		updateEmployee(employee);
	}

	@Override
	public Employee getEmployee(int employeeID) throws TransactionException {
		// TODO Auto-generated method stub
		return (Employee) get(Employee.class, employeeID);
	}

	@Override
	public void removeEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		removeEmployee(employee);
	}

	@Override
	public boolean containsEmployee(Employee employee) throws TransactionException {
		// TODO Auto-generated method stub
		return contains(employee);
	}

	@Override
	public List<Employee> getAllEmployee() throws TransactionException {
		// TODO Auto-generated method stub
		return getList(Employee.class);
	}

	@Override
	public List<Employee> getEmployeeByPerson(int personID) throws TransactionException {
		// TODO Auto-generated method stub
		List<Employee> employees = getAllEmployee();
		List<Employee> results = new ArrayList<Employee>();
		for (Employee emp : employees) {
			if (emp.getPersonID() == personID)
				results.add(emp);
		}
		return results;
	}

	@Override
	public List<Employee> getEmployeeByDivisionOffice(int divisionOfficeId) throws TransactionException {
		// TODO Auto-generated method stub
		List<Employee> result = new ArrayList<Employee>();
		List<EmployeeDivisionOffice> employeeDivisionOffices = getAllEmployeeDivisionOffice();
		for (EmployeeDivisionOffice emDivisionOffice : employeeDivisionOffices) {
			if (emDivisionOffice.getDivisionOfficeID() == divisionOfficeId) {
				Employee emp = getEmployee(emDivisionOffice.getEmployeeID());
				result.add(emp);
			}
		}
		return result;
	}

	@Override
	public void addEmployeeToDivisionOffice(int employeeID, int divisionOfficeID) throws TransactionException {
		// TODO Auto-generated method stub
		EmployeeDivisionOffice emDivisionOffice = new EmployeeDivisionOffice(employeeID, divisionOfficeID);
		add(emDivisionOffice);
	}

	@Override
	public void removeEmployeeFromDivisionOffice(int employeeID, int divisionOfficeID) throws TransactionException {
		// TODO Auto-generated method stub
		EmployeeDivisionOffice emDivisionOffice = new EmployeeDivisionOffice(employeeID, divisionOfficeID);
		remove(emDivisionOffice);
	}

	@Override
	public void addSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		add(signatory);
	}

	@Override
	public int saveSignatory(Signatory signatory) throws TransactionException {
		// TODO Auto-generated method stub
		return (Integer) save(signatory);
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

	@Override
	public List<Signatory> getAllSignatoriesByPerson(Person person) throws TransactionException {
		// TODO Auto-generated method stub
		List<Signatory> signatories = getAllSignatories();
		List<Signatory> result = new ArrayList<Signatory>();
		List<Employee> employees = getEmployeeByPerson(person.getPersonID());
		for (Signatory signatory : signatories) {
			for (Employee emp : employees) {
				if (signatory.getEmployeeID() == emp.getEmployeeID())
					result.add(signatory);
			}
		}
		return result;
	}
}