/**
 * 
 */
package com.iappsam.managers;

import java.util.List;

import com.iappsam.Employee;
import com.iappsam.Person;
import com.iappsam.Signatory;
import com.iappsam.managers.exceptions.DuplicateEntryException;
import com.iappsam.managers.exceptions.TransactionException;

public interface PersonManager extends Manager {

	// Person

	void addPerson(Person person) throws TransactionException, DuplicateEntryException;

	void updatePerson(Person person) throws TransactionException, DuplicateEntryException;

	Person getPerson(int personId) throws TransactionException;

	Person getPerson(String name) throws TransactionException;

	void removePerson(Person person) throws TransactionException;

	boolean containsPerson(Person person) throws TransactionException;

	boolean containsPerson(String name) throws TransactionException;

	List<Person> getAllPersons() throws TransactionException;

	Person getPerson(Person p) throws TransactionException;

	// Employee

	void addEmployee(Employee employee) throws TransactionException, DuplicateEntryException;

	void updateEmployee(Employee employee) throws TransactionException;

	Employee getEmployee(int employeeID) throws TransactionException;

	Employee getEmployee(String name, String designation) throws TransactionException;

	void removeEmployee(Employee employee) throws TransactionException;

	boolean containsEmployee(Employee employee) throws TransactionException;

	List<Employee> getAllEmployee() throws TransactionException;

	// Signatory

	void addSignatory(Signatory signatory) throws TransactionException;

	void updateSignatory(Signatory signatory) throws TransactionException;

	Signatory getSignatory(int signatoryID) throws TransactionException;

	boolean containsSignatory(Signatory signatory) throws TransactionException;

	List<Signatory> getAllSignatories() throws TransactionException;

	@Deprecated
	List<Signatory> getAllSignatoriesByPerson(Person person) throws TransactionException;

	void removeSignatory(Signatory signatory) throws TransactionException;

	List<Employee> getEmployeeByPerson(int personID) throws TransactionException;

	Employee getEmployeeByName(String name) throws TransactionException;

	Employee getEmployee(Employee em) throws TransactionException;

	Employee getEmployee(String id) throws TransactionException;

}
