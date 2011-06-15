package com.iappsam.managers.sessions;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Signatory;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PersonManager;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class PersonManagerSession extends AbstractManager implements PersonManager {

	@Override
	public void addPerson(Person person) throws TransactionException {

		Person p = getPerson(person);
		if (p == null)
			add(person);
		else
			person.setPerson(person);
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
	public Person getPerson(Person p) throws TransactionException {
		return getPerson(p.getId());
	}

	@Override
	public Person getPerson(String name) throws TransactionException {
		List<Person> persons = getAllPersons();
		for (Person p : persons) {
			if (p.getName().equalsIgnoreCase(name))
				return p;
		}
		return null;
	}

	@Override
	public void removePerson(Person person) throws TransactionException {
		remove(person);
	}

	@Override
	public boolean containsPerson(Person person) throws TransactionException {
		return getPerson(person.getId()) != null;
	}

	@Override
	public boolean containsPerson(String name) throws TransactionException {
		return getPerson(name) != null;
	}

	@Override
	public List<Person> getAllPersons() throws TransactionException {
		return getAll(Person.class);
	}

	@Override
	public void addEmployee(Employee employee) throws TransactionException, DuplicateEntryException {
		if (!containsEmployee(employee))
			add(employee);
		else
			throw new DuplicateEntryException();
	}

	@Override
	public Employee getEmployee(int employeeID) throws TransactionException {
		return (Employee) get(Employee.class, employeeID);
	}

	@Override
	public List<Employee> getEmployeeByPerson(int personID) throws TransactionException {
		List<Employee> employees = getAllEmployee();
		List<Employee> results = new ArrayList<Employee>();
		for (Employee emp : employees) {
			if (emp.getPerson().getId() == personID)
				results.add(emp);
		}
		return results;
	}

	@Override
	public Employee getEmployee(Employee em) throws TransactionException {
		return getEmployee(em.getId());
	}

	@Override
	public void removeEmployee(Employee employee) throws TransactionException {
		remove(employee);
	}

	@Override
	public boolean containsEmployee(Employee employee) throws TransactionException {
		return getEmployee(employee.getId()) != null;
	}

	@Override
	public List<Employee> getAllEmployee() throws TransactionException {
		return getAll(Employee.class);
	}

	@Override
	public void addSignatory(Signatory signatory) throws TransactionException {
		add(signatory);
	}

	@Override
	public void updateSignatory(Signatory signatory) throws TransactionException {
		update(signatory);
	}

	@Override
	public Signatory getSignatory(int signatoryID) throws TransactionException {
		return (Signatory) get(Signatory.class, signatoryID);
	}

	@Override
	public boolean containsSignatory(Signatory signatory) throws TransactionException {
		return getSignatory(signatory.getId()) != null;
	}

	@Override
	public List<Signatory> getAllSignatories() throws TransactionException {
		return getAll(Signatory.class);
	}

	@Override
	public void removeSignatory(Signatory signatory) throws TransactionException {
		remove(signatory);
	}

	@Override
	public List<Signatory> getAllSignatoriesByPerson(Person person) throws TransactionException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Employee getEmployee(String name, String designation) throws TransactionException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Employee getEmployeeByName(String name) throws TransactionException {
		Session s = HibernateUtil.startSession();
		Transaction tx = s.beginTransaction();
		try {
			Query q = s.createQuery("Select emp from Employee as emp join emp.person as p where p.name = '" + name + "'");
			Employee emp = (Employee) q.uniqueResult();
			tx.commit();
			return emp;
		} catch (Exception e) {
			tx.rollback();
			throw new TransactionException();
		}
	}

}
